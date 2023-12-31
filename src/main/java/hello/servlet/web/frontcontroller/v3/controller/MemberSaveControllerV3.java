package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> pramMap) {
        String username = pramMap.get("username");
        int age = Integer.parseInt(pramMap.get("age"));

        Member member = new Member(username, age);

        memberRepository.save(member);

        ModelView mv = new ModelView("save");

        mv.getModel().put("member",member);


        return mv;
    }
}
