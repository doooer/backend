package com.plog.doooer.service;

import com.plog.doooer.domain.UserDtlEntity;
import com.plog.doooer.domain.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UpdateUserInfoRequestDTO {
	private long id;
	private String email;
	private String name;
	private String prflImgId;
	private String jobCd;
	private String introduce;
	private String useTech;
	private String educationList;
	private String awardList;
	private String certificateList;
	private String refLink;
	private String refLink2;
	private String openChatUrl;
	
	public UserDtlEntity toUserDtlEntity() {
		return UserDtlEntity.builder()
                .useTech(useTech)
                .educationList(educationList)
                .awardList(awardList)
                .certificateList(certificateList)
                .refLink(refLink)
                .refLink2(refLink2)
                .openChatUrl(openChatUrl)
                .build();
	}
	public UserEntity toUserEntity() {
		return UserEntity.builder()
                .email(email)
                .name(name)
                .prflImgId(prflImgId)
                .jobCd(jobCd)
                .introduce(introduce)
                .build();
	}
}
