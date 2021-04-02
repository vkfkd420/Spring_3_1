package com.iu.s3.notice;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeInsert")
	public void setInsert()throws Exception{}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO,Model model )throws Exception{
		//int result = noticeService.setInsert(noticeDTO);
		Random random = new Random();
		int result = random.nextInt(2);
		
		String message="등록실패";
		String path="./noticeInsert";
		
		
		if(result>0) {
			message="등록성공";
			path="./noticeList";
		}
		model.addAttribute("msg",message);
		model.addAttribute("path",path);
		return "common/commonResult";
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<NoticeDTO> ar = noticeService.getList(pager);
		
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");
		mv.addObject("pager", pager);
		return mv;
	}

}
