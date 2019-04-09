package com.ree.zzamoa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jdbc.Null;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	private	TotalDAO tDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.searchClear(req);
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/main.go", method = RequestMethod.GET)
	public String mainGo(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.searchClear(req);
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/login.go", method = RequestMethod.GET)
	public String loginGo(PhotoList pl, HttpServletRequest req) {
		if(tDAO.loginCheck(req)){
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}else{
			return "login";
		}
	}

	@RequestMapping(value = "/login.check", method = RequestMethod.POST)
	public String loginCheck(PhotoList pl, Member mb, HttpServletRequest req, HttpServletResponse res) {
		tDAO.login(mb, req, res);
		tDAO.loginCheck(req);
		tDAO.paging(1, pl, req);
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginCheck(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.logout(req, res);
		tDAO.loginCheck(req);
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/newJoin.go", method = RequestMethod.GET)
	public String newJoinGo(PhotoList pl, HttpServletRequest req) {
		if(tDAO.loginCheck(req)){
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}else{
			return "newJoin";
		}
	}	

	@RequestMapping(value = "/fileUpload.go", method = RequestMethod.GET)
	public String fileUploadGo(PhotoList pl, HttpServletRequest req) {
		if(tDAO.loginCheck(req)){
			return "fileUpload";
		}else{
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}
	}		

	@RequestMapping(value = "/memberWrite", method = RequestMethod.POST)
	public String memberWrite(PhotoList pl, Member mb, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}else{
			tDAO.memberWrite(mb, req, res);
			return "index";
		}
	}

	@RequestMapping(value = "/member.Del", method = RequestMethod.POST)
	public String memberDel(PhotoList pl, Member mb, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			tDAO.memberDel(mb, req);
		}
		tDAO.logout(req, res);
		tDAO.loginCheck(req);
		tDAO.searchClear(req);
		tDAO.paging(1, pl, req);
		return "index";
	}
			
	@RequestMapping(value = "/memberEdit.go", method = RequestMethod.GET)
	public String memberEdit(PhotoList pl, Member mb, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			return "memberEdit";
		}
		tDAO.searchClear(req);
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/photoWrite", method = RequestMethod.POST)
	public String photoWrite(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			tDAO.photoWrite(pl, req);
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}else{
			tDAO.searchClear(req);
			tDAO.paging(1, pl, req);
			return "index";
		}
	}
	
	@RequestMapping(value = "/photolist.search", method = RequestMethod.GET)
	public String photolistSearch(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.searchPhotolist(pl, req);
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/photoDetail", method = RequestMethod.GET)
	public String photoDetail(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.detailPhoto(pl, req);
		tDAO.paging(1, pl, req);
		
		if(tDAO.masterCheck(req)){
			return "detailphotoEdit";
		}
		return "detailphoto";
	}
	
	@RequestMapping(value = "/photoTag.upload", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody String photoTagUpload(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		try {
			tDAO.updateReply(pl, req);
			pl = tDAO.detailPhoto(pl, req);
			ObjectMapper om = new ObjectMapper();
			String s2 = new String(om.writeValueAsBytes(pl), "utf-8");
			String result = s2;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
	@RequestMapping(value = "/photoDetailEdit.go", method = RequestMethod.GET)
	public String photoDetailEditGO(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.detailPhoto(pl, req);
		tDAO.paging(1, pl, req);
		return "detailphotoEdit";
	}
	
	@RequestMapping(value = "/thumbnail.upload", method = RequestMethod.POST)
	public String thumbnailUpload(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			tDAO.updateThumbnail(pl, req);
		}
		tDAO.detailPhoto(pl, req);
		tDAO.paging(1, pl, req);
		if(tDAO.masterCheck(req)){
			return "detailphotoEdit";
		}
		return "detailphoto";	
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member mb, PhotoList pl, HttpServletRequest req) {
		if(tDAO.loginCheck(req)){
			tDAO.updateMember(mb, req);
			return "memberEdit";
		}else{
			tDAO.paging(1, pl, req);
			return "index";
		}
	}

	@RequestMapping(value = "/photo.del", method = RequestMethod.GET)
	public String photoDel(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		if(tDAO.loginCheck(req)){
			tDAO.PhotoDel(pl, req);
		}
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/PhotoList.AJAX.get", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody String PhotoListAJAXGet(PhotoList pl, HttpServletRequest req) {
		
		try{
			String page = req.getParameter("page");
			int page2 = Integer.parseInt(page);
			String type = req.getParameter("type"); 
			System.out.println("타입값: " + type);
			PhotoLists ps = null;
			if( !(type == null) && type.equals("master")){
				ps = tDAO.MasterPaging(page2, pl, req);		
				System.out.println("마스터로 실행됩니다.");
			} else {
				ps = tDAO.paging(page2, pl, req);
			}
			
			ObjectMapper om = new ObjectMapper();
			String s2 = new String(om.writeValueAsBytes(ps), "utf-8");
			String result = s2;
			
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody boolean idCheck(Member mb, HttpServletRequest req) {
		
		return tDAO.idCheck(mb, req);
		
	}
	
	@RequestMapping(value = "/master.edit", method = RequestMethod.GET)
	public String masterEdit(PhotoList pl, TagList tl, HttpServletRequest req) {
		tDAO.paging(1, pl, req);
		if(tDAO.loginCheck(req)){
			if(tDAO.masterCheck(req)){
				tDAO.tagList(req);
				return "masterEdit";
			}
		}
		return "index";
	}
	
	@RequestMapping(value = "/master.tagUpdate", method = RequestMethod.GET)
	public String masterTagUpdate(PhotoList pl, TagList tl, HttpServletRequest req) {
		if(tDAO.loginCheck(req)){
			if(tDAO.masterCheck(req)){
				tDAO.updatetagList(tl, req);
				tDAO.tagList(req);
				return "masterEdit";
			}
		}
		tDAO.paging(1, pl, req);
		return "index";
	}
	
	@RequestMapping(value = "/PhotoView.update", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody void PhotoViewUpdate(PhotoList pl, HttpServletRequest req) {
		tDAO.updatePhotoView(pl, req);
	}
	
	
	
}
