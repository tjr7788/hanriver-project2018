package hanriver.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hanriver.annotation.Autowired;
import hanriver.annotation.Controller;
import hanriver.annotation.RequestMapping;
import hanriver.dao.NoticeDao;
import hanriver.domain.Notice;

@Controller("/notice/update")
public class NoticeUpdateController {
    
    NoticeDao noticeDao;
    
    public NoticeUpdateController() {}

    public NoticeUpdateController(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }
    
    @Autowired
    public void setNoticeDao(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Notice notice = new Notice();
        notice.setTitle(request.getParameter("title"));
        notice.setContents(request.getParameter("contents"));
        notice.setNo(Integer.parseInt(request.getParameter("no")));
        
        if (noticeDao.update(notice) == 0) {
            return "/notice/updatefail.jsp";
        } else {
            return "redirect:list";
        }
    }
}