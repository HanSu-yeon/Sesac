package board.dto;

import lombok.Data;

@Data
// ��� �ʵ��� getter, setter, toString, hashCode, equals �޼��带 �ڵ����� ����
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

//	public int getBoardIdx() {
//		return boardIdx;
//	}
//
//	public void setBoardIdx(int boardIdx) {
//		this.boardIdx = boardIdx;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	public int getHitCnt() {
//		return hitCnt;
//	}
//
//	public void setHitCnt(int hitCnt) {
//		this.hitCnt = hitCnt;
//	}
//
//	public String getCreatedDatetime() {
//		return createdDatetime;
//	}
//
//	public void setCreatedDatetime(String createdDatetime) {
//		this.createdDatetime = createdDatetime;
//	}
//
//	public String getCreatorId() {
//		return creatorId;
//	}
//
//	public void setCreatorId(String creatorId) {
//		this.creatorId = creatorId;
//	}
//
//	public String getUpdatedDatetime() {
//		return updatedDatetime;
//	}
//
//	public void setUpdatedDatetime(String updatedDatetime) {
//		this.updatedDatetime = updatedDatetime;
//	}
//
//	public String getUpdatorId() {
//		return updatorId;
//	}
//
//	public void setUpdatorId(String updatorId) {
//		this.updatorId = updatorId;
//	}

}
