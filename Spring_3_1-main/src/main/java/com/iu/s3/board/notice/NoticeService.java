package com.iu.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s3.board.BoardDTO;
import com.iu.s3.board.BoardService;
import com.iu.s3.util.Pager;
import com.iu.s3.util.Pager_backUp;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
	}



	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setInsert(boardDTO);
	}



	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
	
		return noticeDAO.setUpdate(boardDTO);
	}



	
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}



	public List<BoardDTO> getList(Pager pager)throws Exception{
	
		// ---- startRow, lastRow ----
		pager.makeRow();
		
		long totalCount = noticeDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
	
		
		
		return noticeDAO.getList(pager);
	}

}