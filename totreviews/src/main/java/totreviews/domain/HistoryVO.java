package totreviews.domain;

import java.sql.Timestamp;

import totreviews.common.enums.Flag;

public class HistoryVO {

	private int historyId; // 히스토리 아이디
	private int trevId; // 여행 후기 아이디
	private Integer trevcId; // 댓글 아이디
	private String memId; // 신고자 아이디
	private String memNick; // 신고자 닉네임
	private String action; // 수행된 액션
	private Timestamp actionDate; // 액션 일시
	private String content; // 신고 내용 또는 게시글/댓글 내용
	private Flag status; // 게시글/댓글의 상태

	public HistoryVO() {
	}

	public HistoryVO(int trevId, String memId, String memNick, String action, String content, Flag status) {
		this.trevId = trevId;
		this.memId = memId;
		this.memNick = memNick;
		this.action = action;
		this.content = content;
		this.status = status;
	}

	public HistoryVO(int historyId, int trevId, Integer trevcId, String memId, String memNick, String action,
			Timestamp actionDate, String content, Flag status) {
		this.historyId = historyId;
		this.trevId = trevId;
		this.trevcId = trevcId;
		this.memId = memId;
		this.memNick = memNick;
		this.action = action;
		this.actionDate = actionDate;
		this.content = content;
		this.status = status;
	}

	public int getHistoryId() {
		return historyId;
	}

	public int getTrevId() {
		return trevId;
	}

	public Integer getTrevcId() {
		return trevcId;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemNick() {
		return memNick;
	}

	public String getAction() {
		return action;
	}

	public Timestamp getActionDate() {
		return actionDate;
	}

	public String getContent() {
		return content;
	}

	public Flag getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "HistoryVO [historyId=" + historyId + ", trevId=" + trevId + ", trevcId=" + trevcId + ", memId=" + memId
				+ ", memNick=" + memNick + ", action=" + action + ", actionDate=" + actionDate + ", content=" + content
				+ ", status=" + status + "]";
	}

}