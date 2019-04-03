package com.ree.zzamoa;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class TotalDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void memberWrite(Member mb, HttpServletRequest req, HttpServletResponse res) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/photo");
			System.out.println(path);

			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			mb.setMb_id(mr.getParameter("mb_id"));
			mb.setMb_pw(mr.getParameter("mb_pw"));
			mb.setMb_name(mr.getParameter("mb_name"));
			mb.setMb_master("0");

			String mb_photo = mr.getFilesystemName("mb_photo");
			if(mb_photo == null){
				mb_photo = "none_photo.jpg";
			}
			mb_photo = URLEncoder.encode(mb_photo, "utf-8");
			mb_photo = mb_photo.replace("+", " ");
			mb.setMb_photo(mb_photo);

			if (ss.getMapper(testMapper.class).member_write(mb) == 1) {
				req.setAttribute("r", "회원가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "회원가입 실패");
		}
	}	
	
	
	public Boolean idCheck(Member mb, HttpServletRequest req){
		try {
			Member dbM = ss.getMapper(testMapper.class).getMemberById(mb);
			if(dbM != null){
				return true;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateMember(Member mb, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/photo");
			System.out.println(path);
		
			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			mb.setMb_id(mr.getParameter("mb_id"));
			mb.setMb_pw(mr.getParameter("mb_pw"));
			mb.setMb_name(mr.getParameter("mb_name"));
			
			String mb_photo = mr.getFilesystemName("mb_photo");
			Member del_photo = (Member) req.getSession().getAttribute("loginMember");
			String del_photo_file = del_photo.getMb_photo();
			
			boolean photoDelCheck = true;
			
			if(mb_photo == null){
				mb_photo = del_photo_file;
				photoDelCheck = false;
			}
			mb_photo = URLEncoder.encode(mb_photo, "utf-8");
			mb_photo = mb_photo.replace("+", " ");
			mb.setMb_photo(mb_photo);
			
			System.out.println("아이디 : "+mb.getMb_id());
			System.out.println("비번 : "+mb.getMb_pw());
			System.out.println("닉네임 : "+mb.getMb_name());
			
			if (ss.getMapper(testMapper.class).updateMember(mb) == 1) {
				req.setAttribute("r", "사진 수정 성공");
				
				Member dbM = ss.getMapper(testMapper.class).getMemberById(mb);
				req.getSession().setAttribute("loginMember", dbM);
				req.getSession().setMaxInactiveInterval(15 * 60);
				
				if(photoDelCheck){
					del_photo_file = URLDecoder.decode(del_photo_file, "utf-8");
					File f = new File(path + "/" + del_photo_file);
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "사진 수정 실패");
		}
	}	
	
	public void login(Member mb, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbM = ss.getMapper(testMapper.class).getMemberById(mb);
			if (dbM != null) {
				if (mb.getMb_pw().equals(dbM.getMb_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(15 * 60);

					String mb_auto = req.getParameter("mb_auto");
					if (mb_auto != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", dbM.getMb_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
				} else {
					req.setAttribute("r", "비번오류");
				}
			} else {
				req.setAttribute("r", "미가입ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "DB서버오류");
		}
	}	
	
	public void autologin(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					String mb_id = c.getValue();
					if (mb_id != null && mb_id != "") {
						try {
							Member md = new Member(mb_id, null, null, null, null);
							Member dbM = ss.getMapper(testMapper.class).getMemberById(md);
							if (dbM != null) {
								req.getSession().setAttribute("loginMember", dbM);
								req.getSession().setMaxInactiveInterval(15 * 60);
							} else {
								req.setAttribute("r", "미가입ID");
							}
						} catch (Exception e) {
							req.setAttribute("r", "DB서버오류");
						}
					}
					break;
				}
			}
		}
	}

	public void memberDel(Member mb, HttpServletRequest req) {
		System.out.println(mb.getMb_id());
		if (ss.getMapper(testMapper.class).memberDel(mb) == 1) {
			req.setAttribute("r", "계정 삭제 성공");
		} else {
			req.setAttribute("r", "계정 삭제 실패");			
		}
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		autologin(req);
		Member md = (Member) req.getSession().getAttribute("loginMember");
		if (md != null) {
			req.setAttribute("headerPage", "include/headLogin.jsp");
			return true;
		}
		req.setAttribute("headerPage", "include/head.jsp");
		return false;
	}
	
	public boolean masterCheck(HttpServletRequest req) {
		Member mb = (Member) req.getSession().getAttribute("loginMember");
		if(mb != null){
			if(mb.getMb_master().equals("1")){
				return true;
			}
		}
		return false;
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res){
		req.getSession().setAttribute("loginMember", null);
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}
	
	public void photoWrite(PhotoList pl, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/photo");
			System.out.println(path);

			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String pl_tag = mr.getParameter("pl_tag");
			pl_tag = pl_tag.replace("+", " ");
			pl.setPl_tag(pl_tag);
			pl.setPl_thumbnail("0");
			pl.setPl_view("0");

			String pl_photo = mr.getFilesystemName("pl_photo");
			pl_photo = URLEncoder.encode(pl_photo, "utf-8");
			pl_photo = pl_photo.replace("+", " ");
			pl.setPl_photo(pl_photo);

			if (ss.getMapper(testMapper.class).photolist_write(pl) == 1) {
				req.setAttribute("r", "사진업로드 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "사진업로드 실패");
		}
	}	
	
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("searchPhotolists", null);		
		req.getSession().setAttribute("searchTag", null);
	}
	public void searchPhotolist(PhotoList pl, HttpServletRequest req){
		req.getSession().setAttribute("searchPhotolists", ss.getMapper(testMapper.class).searchPhotolist(pl));
		req.getSession().setAttribute("searchTag", pl.getPl_tag());
	}
	
	public PhotoLists paging(int pageNo, PhotoList pl, HttpServletRequest req) {
		@SuppressWarnings("unchecked")
		List<PhotoList> searchPhotolists = (List<PhotoList>) req.getSession().getAttribute("searchPhotolists");
		
		double count = 21.0;
		req.setAttribute("curPage", pageNo);

		tagList(req);
		
		if (searchPhotolists != null && searchPhotolists.size() > 0) {
			
			int pageCount = (int) Math.ceil(searchPhotolists.size() / count);
			req.setAttribute("pageCount", pageCount);

			int start = (searchPhotolists.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));

			ArrayList<PhotoList> photoLists = new ArrayList<PhotoList>();
			PhotoList pls = null;
			
			for (int i = start - 1; i >= end - 1; i--) {
				pls = searchPhotolists.get(i);
				photoLists.add(pls);
			}
			PhotoLists pl2 = new PhotoLists(photoLists);
			return pl2;
			
		} else {
			searchPhotolists = ss.getMapper(testMapper.class).getPhotolist(pl);
			System.out.println("전체 데이터량" + searchPhotolists);
			int pageCount = (int) Math.ceil(searchPhotolists.size() / count);
			System.out.println(pageCount);
			req.setAttribute("pageCount", pageCount);

			int start = (searchPhotolists.size() - ((pageNo - 1) * (int) count));		
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));

			PhotoListNo pln = new PhotoListNo(new BigDecimal(start), new BigDecimal(end));
			System.out.println("시작번호 : "+pln.getStart());			
			System.out.println("마지막번호 : "+pln.getEnd());
			List<PhotoList> photoLists = ss.getMapper(testMapper.class).getPhotolistPage(pln);
			System.out.println("뿌려줄 데이터 :" + photoLists);

			PhotoLists pl2 = new PhotoLists(photoLists);
			System.out.println("------------------");
			return pl2;
		}
		
	}
	
	public PhotoList detailPhoto(PhotoList pl, HttpServletRequest req) {
		PhotoList detailPhoto = ss.getMapper(testMapper.class).detailPhotolist(pl);
		req.getSession().setAttribute("detailPhoto", detailPhoto);
		return detailPhoto;
	}
	
	public void updateReply(PhotoList pl, HttpServletRequest req) {
		System.out.println(pl.getPl_tag());
		try {
			if (ss.getMapper(testMapper.class).updatePhotoTag(pl) == 1) {
				req.setAttribute("r", "태그수정 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "태그수정 실패");
		}
	}
	
	public void updateThumbnail(PhotoList pl, HttpServletRequest req) {
			
		try {
			
			String path = req.getSession().getServletContext().getRealPath("resources/photo");
			System.out.println(path);
		
			PhotoList del_photo = (PhotoList) req.getSession().getAttribute("detailPhoto");
			String del_photo_file = del_photo.getPl_thumbnail();
			
			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			BigDecimal pl_number = new BigDecimal(mr.getParameter("pl_number"));
			pl.setPl_number(pl_number);

			String pl_thumbnail = mr.getFilesystemName("pl_thumbnail");
			pl_thumbnail = URLEncoder.encode(pl_thumbnail, "utf-8");
			pl_thumbnail = pl_thumbnail.replace("+", " ");
			pl.setPl_thumbnail(pl_thumbnail);
			
			if (ss.getMapper(testMapper.class).updateThumbnail(pl) == 1) {
				req.setAttribute("r", "썸네일 수정 성공");
				
				del_photo_file = URLDecoder.decode(del_photo_file, "utf-8");
				File f = new File(path + "/" + del_photo_file);
				f.delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "썸네일 수정 실패");
		}
	}
	
	public void PhotoDel(PhotoList pl, HttpServletRequest req){
		try{
			
			PhotoList pl2 = ss.getMapper(testMapper.class).detailPhotolist(pl);
			
			if (ss.getMapper(testMapper.class).PhotoDel(pl) == 1) {
				req.setAttribute("r", "글삭제 성공");
				
				String pl_photo = pl2.getPl_photo();
				String pl_thumbnail = pl2.getPl_thumbnail();
				
				pl_photo = URLDecoder.decode(pl_photo, "utf-8");
				pl_thumbnail = URLDecoder.decode(pl_thumbnail, "utf-8");
				
				String path = req.getSession().getServletContext().getRealPath("resources/photo");
				
				File f = new File(path + "/" + pl_photo);
				f.delete();
				
				if(!pl_thumbnail.equals("0")){
					File f2 = new File(path + "/" + pl_thumbnail);
					f2.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제 실패");
		}
	}
	
	
	public void tagList(HttpServletRequest req) {
		TagList tag = ss.getMapper(testMapper.class).getTagList();
		System.out.println(tag);
		req.setAttribute("tag", tag);
	}
	
	public void updatetagList(TagList tl, HttpServletRequest req) {
		System.out.println(tl.getTag_list());
		try {
			if (ss.getMapper(testMapper.class).updateTagList(tl) == 1) {
				req.setAttribute("r", "태그수정 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "태그수정 실패");
		}
	}
	
}
