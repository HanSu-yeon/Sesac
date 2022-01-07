package board.dto;

import lombok.Data;

@Data // ��� �ʵ��� getter, setter, toString, hashCode, equals �޼��带 �ڵ����� ����
public class BoardDto {

	// DB��Ű���� �°� �ʵ� ����
	private int boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createdDatetime;
	private String creatorId;
	private String updatedDatetime;
	private String updatorId;

}
