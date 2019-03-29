package com.ree.zzamoa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/photoTag.upload", method = RequestMethod.GET)
	public String photoTagUpload(PhotoList pl, HttpServletRequest req, HttpServletResponse res) {
		tDAO.loginCheck(req);
		tDAO.updateReply(pl, req);
		tDAO.detailPhoto(pl, req);
		tDAO.paging(1, pl, req);
		if(tDAO.masterCheck(req)){
			return "detailphotoEdit";
		}
		return "detailphoto";	
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
			PhotoLists ps = tDAO.paging(page2, pl, req);
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
	
}
