package com.example.toy1.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toy1.domain.user.SocialType;
import com.example.toy1.domain.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByNickname(String nickname);

    Optional<UserEntity> findByRefreshToken(String refreshToken);

    /**
     * 소셜 타입과 소셜의 식별값으로 회원 찾는 메소드
     * 정보 제공을 동의한 순간 DB에 저장해야하지만, 아직 추가 정보(사는 도시, 나이 등)를 입력받지 않았으므로
     * 유저 객체는 DB에 있지만, 추가 정보가 빠진 상태이다.
     * 따라서 추가 정보를 입력받아 회원 가입을 진행할 때 소셜 타입, 식별자로 해당 회원을 찾기 위한 메소드
     */
    Optional<UserEntity> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}