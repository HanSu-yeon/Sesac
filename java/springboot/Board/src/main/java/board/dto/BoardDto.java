package board.dto;

import lombok.Data;

@Data // 모든 필드의 getter, setter, toString, hashCode, equals 메서드를 자동으로 생성
public class BoardDto {

	// DB스키마에 맞게 필드 설정
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createdDatetime;
	private String creatorId;
	private String updatedDatetime;
	private String updatorId;

}
