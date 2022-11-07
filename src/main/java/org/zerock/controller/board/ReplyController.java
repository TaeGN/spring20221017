package org.zerock.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.board.ReplyDto;
import org.zerock.service.board.ReplyService;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@GetMapping("list/{boardId}")
	@ResponseBody
	public List<ReplyDto> list(@PathVariable int boardId) {
		return service.listReplyByBoardId(boardId);
	}
	
	@GetMapping("get/{id}")
	@ResponseBody
	public ReplyDto get(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PutMapping("modify")
	@ResponseBody
	public Map<String, Object> modify(@RequestBody ReplyDto reply) {
		Map<String, Object> map = new HashMap<>();
		
		int cnt = service.modify(reply);
		
		if(cnt == 1) {
			map.put("message", reply.getId() + "번 댓글이 수정되었습니다.");
		} else {
			map.put("message", reply.getId() + "번 댓글이 수정되지	않았습니다.");
		}
		
		
		return map;
	}
	
	@DeleteMapping("remove/{id}")
	@ResponseBody
	public Map<String, Object> remove(@PathVariable int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int cnt = service.removeById(id);
		if(cnt == 1) {
			map.put("message", id + "번 댓글이 삭제되었습니다.");
		} else {
			map.put("message", id + "번 댓글이 삭제되지	않았습니다.");
		}
		
		return map;
	}
	
	@PostMapping("add")
	@ResponseBody
	public Map<String, Object> add(@RequestBody ReplyDto reply) {
//		System.out.println(reply);
		int cnt = service.addReply(reply);
		Map<String, Object> map = new HashMap<>();
		
		if(cnt == 1) {
			map.put("message", "새 댓글이 등록되었습니다.");
		} else {
			map.put("message", "새 댓글이 등록되지 않았습니다.");
		}
		return map;
	}
}
