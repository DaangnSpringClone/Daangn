package springstudy.daangnclone.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springstudy.daangnclone.user.controller.port.UserService;
import springstudy.daangnclone.user.domain.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    //join
    public User join() {
        //회원가입 로직
        //유효성 여부 확인 로직(spring validation이 해주므로 생략)
        //기존 회원 가입 여부 확인. 기존 회원인 경우 예외 발생

        //회원가입 처리

        //회원가입 성공시 User 객체 반환
        return null;
    }

    //login
    public User login() {
        //로그인 로직
        //유효성 여부 확인 로직(spring validation이 해주므로 생략)

        //로그인 시간 등록

        //로그인 처리(일단 세션으로 처리) //세션 처리는 domain의 SessionHandler에 위임

        //로그인 성공시 User 객체 반환
        return null;
    }

    //MyInfo
    public User myInfo() {
        //내 정보 로직
        //세션에서 로그인 정보 확인

        //회원 정보 조회

        //회원 정보 반환
        return null;
    }

    public User updateMyInfo() {
        //내 정보 수정 로직
        //세션에서 로그인 정보 확인

        //회원 정보 수정

        //회원 정보 반환
        return null;
    }

    //logout
    public void logout() {
        //로그아웃 로직

        //세션에서 로그인 정보 확인

        //세션 삭제 처리

    }

    //withdraw
    public void withdraw() {
        //탈퇴 로직
        //세션에서 로그인 정보 확인

        //개인정보 삭제

        //회원 삭제(soft delete)

    }

}
