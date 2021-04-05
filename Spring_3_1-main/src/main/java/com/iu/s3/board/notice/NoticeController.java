package com.iu.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping
	public ModelAndView setDelete(BoardDTO boardDTO,ModelAndView modelAndView)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		noticeService.setDelete(boardDTO);
		
		String message ="삭제되었습니다.";
		
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");

////		mv.addObject("board", "notice");
//		mv.setViewName("board/boardDelete");
		mv.setViewName("common/commonResult");
		return mv;
			
		
		
		
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto",boardDTO);
		mv.addObject("board","notice");
		mv.setViewName("board/boardSelect");
		return mv;
		
	}
//	@GetMapping("noticeUpdate")
//	public long setUpdate(BoardDTO boardDTO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		boardDTO = noticeService.setUpdate(boardDTO);
//		mv.addObject("dto",boardDTO);
//		mv.addObject("board","notice");
//		mv.setViewName("board/boardUpdate");
//		
//		return 0;
//	}
	
	
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.setInsert(noticeDTO);
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
	}
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		//List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		return mv;
	}

}