package com.stadion.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.BoxAccountLinkInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.BoxMatchTemplateInfo;
import com.stadion.api.entity.BoxMatchTemplateLinkInfo;
import com.stadion.api.entity.BwHistory;
import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.entity.CommentData;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.GuideBoard;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.InjuryInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.LikeData;
import com.stadion.api.entity.Member;
import com.stadion.api.entity.MemoData;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.entity.MomMovementLinkInfo;
import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.entity.MomRankData;
import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.MovementParticipantLinkInfo;
import com.stadion.api.entity.MovementPointData;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.NoticeBoard;
import com.stadion.api.entity.PolicyAgreeData;
import com.stadion.api.entity.PolicyBoard;
import com.stadion.api.entity.PolicyHistory;
import com.stadion.api.entity.PushBoard;
import com.stadion.api.entity.QnaBoard;
import com.stadion.api.entity.ReportWodItemRecommend;
import com.stadion.api.entity.ReportWodItems;
import com.stadion.api.entity.RestAccountInfo;
import com.stadion.api.entity.StardionLevelData;
import com.stadion.api.entity.TableLinkInfo;
import com.stadion.api.entity.TicketInfo;
import com.stadion.api.entity.TicketPaymentData;
import com.stadion.api.entity.TokenData;
import com.stadion.api.entity.TokenList;
import com.stadion.api.entity.WithdrawData;
import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.entity.WodCategoryInfo;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodItem3RmData;
import com.stadion.api.entity.WodItem5RmData;
import com.stadion.api.entity.WodItemCategoryInfo;
import com.stadion.api.entity.WodItemInfo;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemRankData;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.entity.WodRoundInfo;
import com.stadion.api.entity.WodRoundItemInfo;
import com.stadion.api.entity.WodStepInfo;
import com.stadion.api.entity.WodTemplateInfo;
import com.stadion.api.entity.WodTemplateRecordInfo;
import com.stadion.api.entity.WodTemplateRoundInfo;
import com.stadion.api.entity.WodTemplateRoundItemInfo;
import com.stadion.api.entity.WodTemplateStepInfo;
import com.stadion.api.service.AccountInfoService;
import com.stadion.api.service.ActionHistoryService;
import com.stadion.api.service.BoxAccountLinkInfoService;
import com.stadion.api.service.BoxInfoService;
import com.stadion.api.service.BoxMatchTemplateInfoService;
import com.stadion.api.service.BoxMatchTemplateLinkInfoService;
import com.stadion.api.service.BwHistoryService;
import com.stadion.api.service.CategoryInfoService;
import com.stadion.api.service.CommentDataService;
import com.stadion.api.service.EventBoardService;
import com.stadion.api.service.FaqBoardService;
import com.stadion.api.service.FileDataService;
import com.stadion.api.service.GuideBoardService;
import com.stadion.api.service.InjuryDataService;
import com.stadion.api.service.InjuryInfoService;
import com.stadion.api.service.LevelDataService;
import com.stadion.api.service.LikeDataService;
import com.stadion.api.service.MemberService;
import com.stadion.api.service.MemoDataService;
import com.stadion.api.service.MomInfoService;
import com.stadion.api.service.MomMovementLinkInfoService;
import com.stadion.api.service.MomParticipantLinkInfoService;
import com.stadion.api.service.MomRankDataService;
import com.stadion.api.service.MovementInfoService;
import com.stadion.api.service.MovementParticipantLinkInfoService;
import com.stadion.api.service.MovementPointDataService;
import com.stadion.api.service.MovementRecordDataService;
import com.stadion.api.service.NoticeBoardService;
import com.stadion.api.service.PolicyAgreeDataService;
import com.stadion.api.service.PolicyBoardService;
import com.stadion.api.service.PolicyHistoryService;
import com.stadion.api.service.PushBoardService;
import com.stadion.api.service.QnaBoardService;
import com.stadion.api.service.ReportWodItemRecommendService;
import com.stadion.api.service.ReportWodItemsService;
import com.stadion.api.service.RestAccountInfoService;
import com.stadion.api.service.StardionLevelDataService;
import com.stadion.api.service.TableLinkInfoService;
import com.stadion.api.service.TicketInfoService;
import com.stadion.api.service.TicketPaymentDataService;
import com.stadion.api.service.TokenDataService;
import com.stadion.api.service.TokenListService;
import com.stadion.api.service.WithdrawDataService;
import com.stadion.api.service.WodBoxLinkInfoService;
import com.stadion.api.service.WodCategoryInfoService;
import com.stadion.api.service.WodInfoService;
import com.stadion.api.service.WodItem3RmDataService;
import com.stadion.api.service.WodItem5RmDataService;
import com.stadion.api.service.WodItemCategoryInfoService;
import com.stadion.api.service.WodItemInfoService;
import com.stadion.api.service.WodItemOneRmDataService;
import com.stadion.api.service.WodItemRankDataService;
import com.stadion.api.service.WodItemRecordDataService;
import com.stadion.api.service.WodParticipantLinkInfoService;
import com.stadion.api.service.WodRecordInfoService;
import com.stadion.api.service.WodRoundInfoService;
import com.stadion.api.service.WodRoundItemInfoService;
import com.stadion.api.service.WodStepInfoService;
import com.stadion.api.service.WodTemplateInfoService;
import com.stadion.api.service.WodTemplateRecordInfoService;
import com.stadion.api.service.WodTemplateRoundInfoService;
import com.stadion.api.service.WodTemplateRoundItemInfoService;
import com.stadion.api.service.WodTemplateStepInfoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import lombok.ToString;


@RestController
public class MainApiController {
    @Autowired
    public MemberService memberService;

    @RequestMapping(value = "/member")
    public List<Member> getTest() throws Exception{
    	//List<Member> memberList = memberService.getMember();
    	//model.addAttribute("list", memberList);
        return memberService.getMember();
    }

    // 결과를 JSON으로 변경
    @RequestMapping(value = "/getmember", method = RequestMethod.GET)
	public String getMember() {
    	String result;
    	Gson gson = new Gson();
    	List<Member> list = memberService.getMember();

    	result = gson.toJson(list);
    	
    	
		return result;

	}

    
    @Autowired
    public AccountInfoService acountInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getaccountinfo")
	public String getAccountInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	AccountInfo jsonResult = acountInfoService.getAccountInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getaccountinfobyemail")
	public String getAccountInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	AccountInfo jsonResult = acountInfoService.getAccountInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}

    
    @Autowired
    public ActionHistoryService actionHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getactionHistory")
	public String getActionHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	int idx  = (int) object.get("idx");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ActionHistory jsonResult = actionHistoryService.getActionHistory(idx);

    	result = gson.toJson(jsonResult);
    	return result;
	}

    
    @Autowired
    public BoxAccountLinkInfoService boxAccountLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxAccountLinkInfo")
	public String getBoxAccountLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxAccountLinkInfo jsonResult = boxAccountLinkInfoService.getBoxAccountLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getboxAccountLinkInfobyemail")
	public String getBoxAccountLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	BoxAccountLinkInfo jsonResult = boxAccountLinkInfoService.getBoxAccountLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public BoxInfoService boxInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxInfo")
	public String getBoxInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxInfo jsonResult = boxInfoService.getBoxInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getboxInfobyemail")
	public String getBoxInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	BoxInfo jsonResult = boxInfoService.getBoxInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public BoxMatchTemplateInfoService boxMatchTemplateInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxMatchTemplateInfo")
	public String getBoxMatchTemplateInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxMatchTemplateInfo jsonResult = boxMatchTemplateInfoService.getBoxMatchTemplateInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getboxMatchTemplateInfobyemail")
	public String getBoxMatchTemplateInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	BoxMatchTemplateInfo jsonResult = boxMatchTemplateInfoService.getBoxMatchTemplateInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public BoxMatchTemplateLinkInfoService boxMatchTemplateLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getboxMatchTemplateLinkInfo")
	public String getBoxMatchTemplateLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BoxMatchTemplateLinkInfo jsonResult = boxMatchTemplateLinkInfoService.getBoxMatchTemplateLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getboxMatchTemplateLinkInfobyemail")
	public String getBoxMatchTemplateLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	BoxMatchTemplateLinkInfo jsonResult = boxMatchTemplateLinkInfoService.getBoxMatchTemplateLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public BwHistoryService bwHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getbwHistory")
	public String getBwHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	BwHistory jsonResult = bwHistoryService.getBwHistory(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getbwHistorybyemail")
	public String getBwHistoryByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	BwHistory jsonResult = bwHistoryService.getBwHistoryByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public CategoryInfoService categoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getcategoryInfo")
	public String getCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	CategoryInfo jsonResult = categoryInfoService.getCategoryInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getcategoryInfobyemail")
	public String getCategoryInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	CategoryInfo jsonResult = categoryInfoService.getCategoryInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public CommentDataService commentDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getcommentData")
	public String getCommentData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	CommentData jsonResult = commentDataService.getCommentData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getcommentDatabyemail")
	public String getCommentDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	CommentData jsonResult = commentDataService.getCommentDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public EventBoardService eventBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/geteventBoard")
	public String getEventBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	EventBoard jsonResult = eventBoardService.getEventBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/geteventBoardbyemail")
	public String getEventBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	EventBoard jsonResult = eventBoardService.getEventBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public FaqBoardService faqBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getfaqBoard")
	public String getFaqBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	FaqBoard jsonResult = faqBoardService.getFaqBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getfaqBoardbyemail")
	public String getFaqBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	FaqBoard jsonResult = faqBoardService.getFaqBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public FileDataService fileDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getfileData")
	public String getFileData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	FileData jsonResult = fileDataService.getFileData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getfileDatabyemail")
	public String getFileDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	FileData jsonResult = fileDataService.getFileDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public GuideBoardService guideBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getguideBoard")
	public String getGuideBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	GuideBoard jsonResult = guideBoardService.getGuideBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getguideBoardbyemail")
	public String getGuideBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	GuideBoard jsonResult = guideBoardService.getGuideBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public InjuryDataService injuryDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getinjuryData")
	public String getInjuryData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	InjuryData jsonResult = injuryDataService.getInjuryData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getinjuryDatabyemail")
	public String getInjuryDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	InjuryData jsonResult = injuryDataService.getInjuryDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public InjuryInfoService injuryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getinjuryInfo")
	public String getInjuryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	InjuryInfo jsonResult = injuryInfoService.getInjuryInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getinjuryInfobyemail")
	public String getInjuryInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	InjuryInfo jsonResult = injuryInfoService.getInjuryInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public LevelDataService levelDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getlevelData")
	public String getLevelData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	LevelData jsonResult = levelDataService.getLevelData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getlevelDatabyemail")
	public String getLevelDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	LevelData jsonResult = levelDataService.getLevelDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public LikeDataService likeDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getlikeData")
	public String getLikeData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	LikeData jsonResult = likeDataService.getLikeData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getlikeDatabyemail")
	public String getLikeDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	LikeData jsonResult = likeDataService.getLikeDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MemoDataService memoDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmemoData")
	public String getMemoData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MemoData jsonResult = memoDataService.getMemoData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmemoDatabyemail")
	public String getMemoDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MemoData jsonResult = memoDataService.getMemoDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MomInfoService momInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomInfo")
	public String getMomInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomInfo jsonResult = momInfoService.getMomInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmomInfobyemail")
	public String getMomInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MomInfo jsonResult = momInfoService.getMomInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MomMovementLinkInfoService momMovementLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomMovementLinkInfo")
	public String getMomMovementLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomMovementLinkInfo jsonResult = momMovementLinkInfoService.getMomMovementLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmomMovementLinkInfobyemail")
	public String getMomMovementLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MomMovementLinkInfo jsonResult = momMovementLinkInfoService.getMomMovementLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MomParticipantLinkInfoService momParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomParticipantLinkInfo")
	public String getMomParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomParticipantLinkInfo jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmomParticipantLinkInfobyemail")
	public String getMomParticipantLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MomParticipantLinkInfo jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MomRankDataService momRankDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmomRankData")
	public String getMomRankData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MomRankData jsonResult = momRankDataService.getMomRankData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmomRankDatabyemail")
	public String getMomRankDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MomRankData jsonResult = momRankDataService.getMomRankDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MovementInfoService movementInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementInfo")
	public String getMovementInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementInfo jsonResult = movementInfoService.getMovementInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmovementInfobyemail")
	public String getMovementInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MovementInfo jsonResult = movementInfoService.getMovementInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MovementParticipantLinkInfoService movementParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementParticipantLinkInfo")
	public String getMovementParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementParticipantLinkInfo jsonResult = movementParticipantLinkInfoService.getMovementParticipantLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmovementParticipantLinkInfobyemail")
	public String getMovementParticipantLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MovementParticipantLinkInfo jsonResult = movementParticipantLinkInfoService.getMovementParticipantLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MovementPointDataService movementPointDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementPointData")
	public String getMovementPointData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementPointData jsonResult = movementPointDataService.getMovementPointData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmovementPointDatabyemail")
	public String getMovementPointDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MovementPointData jsonResult = movementPointDataService.getMovementPointDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public MovementRecordDataService movementRecordDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getmovementRecordData")
	public String getMovementRecordData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	MovementRecordData jsonResult = movementRecordDataService.getMovementRecordData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getmovementRecordDatabyemail")
	public String getMovementRecordDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	MovementRecordData jsonResult = movementRecordDataService.getMovementRecordDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public NoticeBoardService noticeBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getnoticeBoard")
	public String getNoticeBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	NoticeBoard jsonResult = noticeBoardService.getNoticeBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getgetnoticeBoardbyemail")
	public String getNoticeBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	NoticeBoard jsonResult = noticeBoardService.getNoticeBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public PolicyAgreeDataService policyAgreeDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyAgreeData")
	public String getPolicyAgreeData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyAgreeData jsonResult = policyAgreeDataService.getPolicyAgreeData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getpolicyAgreeDatabyemail")
	public String getPolicyAgreeDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	PolicyAgreeData jsonResult = policyAgreeDataService.getPolicyAgreeDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public PolicyBoardService policyBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyBoard")
	public String getPolicyBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyBoard jsonResult = policyBoardService.getPolicyBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getgetpolicyBoardbyemail")
	public String getPolicyBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	PolicyBoard jsonResult = policyBoardService.getPolicyBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public PolicyHistoryService policyHistoryService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpolicyHistory")
	public String getPolicyHistory(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PolicyHistory jsonResult = policyHistoryService.getPolicyHistory(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getpolicyHistorybyemail")
	public String getgetPolicyHistoryByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	PolicyHistory jsonResult = policyHistoryService.getPolicyHistoryByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public PushBoardService pushBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getpushBoard")
	public String getPushBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	PushBoard jsonResult = pushBoardService.getPushBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getpushBoardbyemail")
	public String getPushBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	PushBoard jsonResult = pushBoardService.getPushBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public QnaBoardService qnaBoardService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getqnaBoard")
	public String getQnaBoard(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	QnaBoard jsonResult = qnaBoardService.getQnaBoard(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getqnaBoardbyemail")
	public String getQnaBoardByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	QnaBoard jsonResult = qnaBoardService.getQnaBoardByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public ReportWodItemRecommendService reportWodItemRecommendService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getreportWodItemRecommend")
	public String getReportWodItemRecommend(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ReportWodItemRecommend jsonResult = reportWodItemRecommendService.getReportWodItemRecommend(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getreportWodItemRecommendbyemail")
	public String getReportWodItemRecommendByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	ReportWodItemRecommend jsonResult = reportWodItemRecommendService.getReportWodItemRecommendByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public ReportWodItemsService reportWodItemsService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getreportWodItems")
	public String getReportWodItems(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	ReportWodItems jsonResult = reportWodItemsService.getReportWodItems(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getreportWodItemsbyemail")
	public String getReportWodItemsByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	ReportWodItems jsonResult = reportWodItemsService.getReportWodItemsByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public RestAccountInfoService restAccountInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getrestAccountInfo")
	public String getRestAccountInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	RestAccountInfo jsonResult = restAccountInfoService.getRestAccountInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getrestAccountInfobyemail")
	public String getRestAccountInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	RestAccountInfo jsonResult = restAccountInfoService.getRestAccountInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public StardionLevelDataService stardionLevelDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getstardionLevelData")
	public String getStardionLevelData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	StardionLevelData jsonResult = stardionLevelDataService.getStardionLevelData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getstardionLevelDatabyemail")
	public String getStardionLevelDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	StardionLevelData jsonResult = stardionLevelDataService.getStardionLevelDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public TableLinkInfoService tableLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/gettableLinkInfo")
	public String getTableLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TableLinkInfo jsonResult = tableLinkInfoService.getTableLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/gettableLinkInfobyemail")
	public String getTableLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	TableLinkInfo jsonResult = tableLinkInfoService.getTableLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public TicketInfoService ticketInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getticketInfo")
	public String getTicketInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TicketInfo jsonResult = ticketInfoService.getTicketInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getticketInfobyemail")
	public String getTicketInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	TicketInfo jsonResult = ticketInfoService.getTicketInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public TicketPaymentDataService ticketPaymentDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getticketPaymentData")
	public String getTicketPaymentData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TicketPaymentData jsonResult = ticketPaymentDataService.getTicketPaymentData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getticketPaymentDatabyemail")
	public String getTicketPaymentDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	TicketPaymentData jsonResult = ticketPaymentDataService.getTicketPaymentDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public TokenDataService tokenDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/gettokenData")
	public String getTokenData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TokenData jsonResult = tokenDataService.getTokenData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/gettokenDatabyemail")
	public String getTokenDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	TokenData jsonResult = tokenDataService.getTokenDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public TokenListService tokenListService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/gettokenList")
	public String getTokenList(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	TokenList jsonResult = tokenListService.getTokenList(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/gettokenListbyemail")
	public String getTokenListByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	TokenList jsonResult = tokenListService.getTokenListByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WithdrawDataService withdrawDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwithdrawData")
	public String getWithdrawData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WithdrawData jsonResult = withdrawDataService.getWithdrawData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwithdrawDatabyemail")
	public String getWithdrawDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WithdrawData jsonResult = withdrawDataService.getWithdrawDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodBoxLinkInfoService wodBoxLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodBoxLinkInfo")
	public String getWodBoxLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodBoxLinkInfo jsonResult = wodBoxLinkInfoService.getWodBoxLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodBoxLinkInfobyemail")
	public String getgetWodBoxLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodBoxLinkInfo jsonResult = wodBoxLinkInfoService.getWodBoxLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodCategoryInfoService wodCategoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodCategoryInfo")
	public String getWodCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodCategoryInfo jsonResult = wodCategoryInfoService.getWodCategoryInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodCategoryInfobyemail")
	public String getWodCategoryInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodCategoryInfo jsonResult = wodCategoryInfoService.getWodCategoryInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodInfoService wodInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodInfo")
	public String getWodInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodInfo jsonResult = wodInfoService.getWodInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getgetwodInfobyemail")
	public String getWodInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodInfo jsonResult = wodInfoService.getWodInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItem3RmDataService wodItem3RmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItem3RmData")
	public String getWodItem3RmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItem3RmData jsonResult = wodItem3RmDataService.getWodItem3RmData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItem3RmDatabyemail")
	public String getWodItem3RmDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItem3RmData jsonResult = wodItem3RmDataService.getWodItem3RmDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItem5RmDataService wodItem5RmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItem5RmData")
	public String getWodItem5RmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItem5RmData jsonResult = wodItem5RmDataService.getWodItem5RmData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItem5RmDatabyemail")
	public String getWodItem5RmDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItem5RmData jsonResult = wodItem5RmDataService.getWodItem5RmDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItemCategoryInfoService wodItemCategoryInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemCategoryInfo")
	public String getWodItemCategoryInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemCategoryInfo jsonResult = wodItemCategoryInfoService.getWodItemCategoryInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItemCategoryInfobyemail")
	public String getWodItemCategoryInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItemCategoryInfo jsonResult = wodItemCategoryInfoService.getWodItemCategoryInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItemInfoService wodItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemInfo")
	public String getWodItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemInfo jsonResult = wodItemInfoService.getWodItemInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItemInfobyemail")
	public String getWodItemInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItemInfo jsonResult = wodItemInfoService.getWodItemInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItemOneRmDataService wodItemOneRmDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemOneRmData")
	public String getWodItemOneRmData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemOneRmData jsonResult = wodItemOneRmDataService.getWodItemOneRmData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItemOneRmDatabyemail")
	public String getWodItemOneRmDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItemOneRmData jsonResult = wodItemOneRmDataService.getWodItemOneRmDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItemRankDataService wodItemRankDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemRankData")
	public String getWodItemRankData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemRankData jsonResult = wodItemRankDataService.getWodItemRankData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItemRankDatabyemail")
	public String getWodItemRankDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItemRankData jsonResult = wodItemRankDataService.getWodItemRankDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodItemRecordDataService wodItemRecordDataService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodItemRecordData")
	public String getWodItemRecordData(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodItemRecordData jsonResult = wodItemRecordDataService.getWodItemRecordData(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodItemRecordDatabyemail")
	public String getWodItemRecordDataByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodItemRecordData jsonResult = wodItemRecordDataService.getWodItemRecordDataByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodParticipantLinkInfoService wodParticipantLinkInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodParticipantLinkInfo")
	public String getWodParticipantLinkInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodParticipantLinkInfo jsonResult = wodParticipantLinkInfoService.getWodParticipantLinkInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodParticipantLinkInfobyemail")
	public String getgetWodParticipantLinkInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodParticipantLinkInfo jsonResult = wodParticipantLinkInfoService.getWodParticipantLinkInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodRecordInfoService wodRecordInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRecordInfo")
	public String getWodRecordInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRecordInfo jsonResult = wodRecordInfoService.getWodRecordInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodRecordInfobyemail")
	public String getWodRecordInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodRecordInfo jsonResult = wodRecordInfoService.getWodRecordInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodRoundInfoService wodRoundInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRoundInfo")
	public String getWodRoundInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRoundInfo jsonResult = wodRoundInfoService.getWodRoundInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodRoundInfobyemail")
	public String getWodRoundInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodRoundInfo jsonResult = wodRoundInfoService.getWodRoundInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodRoundItemInfoService wodRoundItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodRoundItemInfo")
	public String getWodRoundItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodRoundItemInfo jsonResult = wodRoundItemInfoService.getWodRoundItemInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodRoundItemInfobyemail")
	public String getWodRoundItemInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodRoundItemInfo jsonResult = wodRoundItemInfoService.getWodRoundItemInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodStepInfoService wodStepInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodStepInfo")
	public String getWodStepInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodStepInfo jsonResult = wodStepInfoService.getWodStepInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodStepInfobyemail")
	public String getWodStepInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodStepInfo jsonResult = wodStepInfoService.getWodStepInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodTemplateInfoService wodTemplateInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateInfo")
	public String getWodTemplateInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateInfo jsonResult = wodTemplateInfoService.getWodTemplateInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodTemplateInfobyemail")
	public String getWodTemplateInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodTemplateInfo jsonResult = wodTemplateInfoService.getWodTemplateInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodTemplateRecordInfoService wodTemplateRecordInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRecordInfo")
	public String getWodTemplateRecordInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRecordInfo jsonResult = wodTemplateRecordInfoService.getWodTemplateRecordInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodTemplateRecordInfobyemail")
	public String getWodTemplateRecordInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodTemplateRecordInfo jsonResult = wodTemplateRecordInfoService.getWodTemplateRecordInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodTemplateRoundInfoService wodTemplateRoundInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRoundInfo")
	public String getWodTemplateRoundInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRoundInfo jsonResult = wodTemplateRoundInfoService.getWodTemplateRoundInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodTemplateRoundInfobyemail")
	public String getWodTemplateRoundInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodTemplateRoundInfo jsonResult = wodTemplateRoundInfoService.getWodTemplateRoundInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodTemplateRoundItemInfoService wodTemplateRoundItemInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateRoundItemInfo")
	public String getWodTemplateRoundItemInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateRoundItemInfo jsonResult = wodTemplateRoundItemInfoService.getWodTemplateRoundItemInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodTemplateRoundItemInfobyemail")
	public String getWodTemplateRoundItemInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodTemplateRoundItemInfo jsonResult = wodTemplateRoundItemInfoService.getWodTemplateRoundItemInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
    
    @Autowired
    public WodTemplateStepInfoService wodTemplateStepInfoService;
     
    // POST는 @PostMapping 사용
    @PostMapping("/getwodTemplateStepInfo")
	public String getWodTemplateStepInfo(
			// 인자 전달, json으로 옴
			@RequestBody String paramJson
			) throws ParseException {
    	
    	//System.out.println(paramJson);
    	
    	// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값 userID
    	String userID = (String) object.get("userID");
    	
    	String result;
    	Gson gson = new Gson();
    	
    	WodTemplateStepInfo jsonResult = wodTemplateStepInfoService.getWodTemplateStepInfo(userID);

    	result = gson.toJson(jsonResult);
    	return result;
	}


    @PostMapping("/getwodTemplateStepInfobyemail")
	public String getWodTemplateStepInfoByEmailAddress(
			// 인자 전달, json으로 옴
						@RequestBody String paramJson
			) throws ParseException {
		// 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
    	JSONParser parser = new JSONParser();
    	JSONObject object = (JSONObject) parser.parse(paramJson);

    	// 필요값을 get 해서 전달
    	String emailAddress = (String) object.get("emailAddress");
    	String result;
    	Gson gson = new Gson();
    	WodTemplateStepInfo jsonResult = wodTemplateStepInfoService.getWodTemplateStepInfoByEmail(emailAddress);

    	result = gson.toJson(jsonResult);
    	
		return result;
	}
    
}