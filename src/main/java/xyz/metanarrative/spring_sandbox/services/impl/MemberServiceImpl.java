package xyz.metanarrative.spring_sandbox.services.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.metanarrative.spring_sandbox.entities.Member;
import xyz.metanarrative.spring_sandbox.repositories.MemberRepository;
import xyz.metanarrative.spring_sandbox.services.MemberService;

@Transactional(rollbackFor = Exception.class)
@Service("msi")
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public String getMember(int id) {
        Member member = memberRepository.findMemberById(id);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(member.getBand());
    }
}
