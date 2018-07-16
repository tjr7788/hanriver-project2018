package hanriver.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hanriver.dao.MemberDao;
import hanriver.domain.Member;

@Controller
public class MemberUpdateController {
    
    
    MemberDao memberDao;
    
    public MemberUpdateController() {}

    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/member/update")
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Member member = new Member();
        
        member.setEmail(request.getParameter("email"));
        member.setPassword(request.getParameter("password"));
        member.setId(request.getParameter("id"));
        member.setTel(request.getParameter("tel"));
        
        if (memberDao.update(member) == 0) {
            return "member/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
}
