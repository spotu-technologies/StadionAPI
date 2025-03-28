package com.stadion.api.controller;


import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.AccountNameNick;
import com.stadion.api.entity.ActionHistory;
import com.stadion.api.entity.BadgeAccountLinkInfo;
import com.stadion.api.entity.BadgeInfo;
import com.stadion.api.entity.BoxAccountLinkInfo;
import com.stadion.api.entity.BoxInfo;
import com.stadion.api.entity.BoxMatchTemplateInfo;
import com.stadion.api.entity.BoxMatchTemplateLinkInfo;
import com.stadion.api.entity.BwHistory;
import com.stadion.api.entity.CategoryInfo;
import com.stadion.api.entity.ChatData;
import com.stadion.api.entity.CommentData;
import com.stadion.api.entity.EventBoard;
import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.FileData;
import com.stadion.api.entity.FollowLinkInfo;
import com.stadion.api.entity.FollowList;
import com.stadion.api.entity.GuideBoard;
import com.stadion.api.entity.InjuryData;
import com.stadion.api.entity.InjuryInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.LikeData;
import com.stadion.api.entity.LoginInfo;
import com.stadion.api.entity.LoginInfoV2;
import com.stadion.api.entity.Member;
import com.stadion.api.entity.MemoData;
import com.stadion.api.entity.MomAttend;
import com.stadion.api.entity.MomAttendByDay;
import com.stadion.api.entity.MomHistory;
import com.stadion.api.entity.MomInfo;
import com.stadion.api.entity.MomInfoWithFile;
import com.stadion.api.entity.MomMovementLinkInfo;
import com.stadion.api.entity.MomMovementRankInfo;
import com.stadion.api.entity.MomParticipantLinkInfo;
import com.stadion.api.entity.MomRankData;
import com.stadion.api.entity.MomRankDataResult;
import com.stadion.api.entity.MomSummary;
import com.stadion.api.entity.MomTeamInfo;
import com.stadion.api.entity.MomTeamMemberInfo;
import com.stadion.api.entity.MovementInfo;
import com.stadion.api.entity.MovementParticipantLinkInfo;
import com.stadion.api.entity.MovementPointData;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.MovementRecordDataDetail;
import com.stadion.api.entity.NoticeBoard;
import com.stadion.api.entity.NumbersRankData;
import com.stadion.api.entity.NumbersRankDataIdx;
import com.stadion.api.entity.PolicyAgreeData;
import com.stadion.api.entity.PolicyBoard;
import com.stadion.api.entity.PolicyHistory;
import com.stadion.api.entity.PushBoard;
import com.stadion.api.entity.QnaBoard;
import com.stadion.api.entity.RangedArg;
import com.stadion.api.entity.RankingDataParameter;
import com.stadion.api.entity.ReportWodItemRecommend;
import com.stadion.api.entity.ReportWodItems;
import com.stadion.api.entity.RestAccountInfo;
import com.stadion.api.entity.ScaleGender;
import com.stadion.api.entity.SqlVO;
import com.stadion.api.entity.StardionLevelData;
import com.stadion.api.entity.TableLinkInfo;
import com.stadion.api.entity.TicketInfo;
import com.stadion.api.entity.TicketPaymentData;
import com.stadion.api.entity.TokenData;
import com.stadion.api.entity.TokenList;
import com.stadion.api.entity.WithdrawData;
import com.stadion.api.entity.WodBoxInfoTime;
import com.stadion.api.entity.WodBoxLinkInfo;
import com.stadion.api.entity.WodBoxLinkInfoName;
import com.stadion.api.entity.WodCategoryInfo;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodInfoNameIdx;
import com.stadion.api.entity.WodInfoWithFile;
import com.stadion.api.entity.WodItem3RmData;
import com.stadion.api.entity.WodItem5RmData;
import com.stadion.api.entity.WodItemCategoryInfo;
import com.stadion.api.entity.WodItemInfo;
import com.stadion.api.entity.WodItemInsertRmData;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.entity.WodItemOneRmDataHistory;
import com.stadion.api.entity.WodItemRankData;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.entity.WodItemRecordDataDetail;
import com.stadion.api.entity.WodItemRecordDataRanking;
import com.stadion.api.entity.WodItemRmData;
import com.stadion.api.entity.WodParticipantLinkInfo;
import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.entity.WodRecordInfoWithBox;
import com.stadion.api.entity.WodRoundInfo;
import com.stadion.api.entity.WodRoundItemInfo;
import com.stadion.api.entity.WodStepInfo;
import com.stadion.api.entity.WodTemplateInfo;
import com.stadion.api.entity.WodTemplateRecordInfo;
import com.stadion.api.entity.WodTemplateRoundInfo;
import com.stadion.api.entity.WodTemplateRoundItemInfo;
import com.stadion.api.entity.WodTemplateStepInfo;
import com.stadion.api.mapper.ChatDataMapper;
import com.stadion.api.service.AccountInfoService;
import com.stadion.api.service.ActionHistoryService;
import com.stadion.api.service.BadgeAccountLinkInfoService;
import com.stadion.api.service.BadgeInfoService;
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
import com.stadion.api.service.FollowLinkInfoService;
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

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;


@RestController
public class MainApiController {
    public static final String ACCOUNT_ID = "사용자 ID";
    public static final String ACCOUNT_IDX = "사용자 idx";
    public static final String WOD_IDX = "wod idx";

    String lbsToKg(String lb) {
        double lbs = Double.parseDouble(lb);
        //kg = lbs / 2.20462
        double kg = lbs / 2.20462;
        return String.format("%.1f", kg);
    }

    String kgToLbs(String kg) {
        double kgs = Double.parseDouble(kg);
        //lbs = kg*2.20462
        double lbs = kgs * 2.20462;
        return String.format("%.1f", lbs);
    }


    @GetMapping(path = "/")
    public String RootController() {
        return "root page";
    }

    @GetMapping(path = "/index")
    public int IndexController() {
        return 10;
    }

    @ApiOperation(
            value = "value?"
            , notes = "tips?.")
    @GetMapping("/demo")
    public String DemoController() {
        return "demo page";
    }

    @Autowired
    public MemberService memberService;

    @RequestMapping(value = "/member")
    public List<Member> getTest() throws Exception {
        //List<Member> memberList = memberService.getMember();
        //model.addAttribute("list", memberList);
        return memberService.getMember();
    }

    @GetMapping("/getmember")
    public String getMember() {
        String result;
        Gson gson = new Gson();
        List<Member> list = memberService.getMember();

        result = gson.toJson(list);
        return result;
    }

    @Autowired
    public AccountInfoService accountInfoService;

    @PostMapping(value = "/getaccountinfologinV2", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfoLoginV2(
            @RequestBody String paramJson
    ) throws ParseException {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Start time : " + dateFormat.format(date));
        long startLong = System.currentTimeMillis();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        LoginInfoV2 loginInfo = new LoginInfoV2();

        long middleLong = System.currentTimeMillis();

        long pIdx = accountIdx;
        String fileKindVideo = "V";
        String fileKindImage = "C";

        List<FileData> fileDataGuideThumnail = fileDataService.getFileDataFile(fileKindImage, 11, pIdx);
        List<FileData> fileDataGuideVideo = fileDataService.getFileDataFile(fileKindVideo, 11, pIdx);
        List<FileData> fileDataProfileImage = fileDataService.getFileDataImage(fileKindImage, 1, pIdx);
        List<FileData> fileDataMtc = fileDataService.getFileDataMtc(fileKindImage, 17, pIdx);
        List<FileData> fileDataWod = fileDataService.getFileDataMtc(fileKindImage, 37, pIdx);

        loginInfo.fileDataGuideThumnail = fileDataGuideThumnail;
        loginInfo.fileDataGuideVideo = fileDataGuideVideo;
        loginInfo.fileDataProfileImage = fileDataProfileImage;
        loginInfo.fileDataMtc = fileDataMtc;
        loginInfo.fileDataWod = fileDataWod;

        long idx = accountIdx;    //resultAccount.idx;

        List<LevelData> levelData = levelDataService.getLevelData(idx);
        loginInfo.levelData = levelData;

        result = gson.toJson(loginInfo);

        date = new Date();
        System.out.println("End time : " + dateFormat.format(date));
        return result;
    }

    @PostMapping(value = "/getAccountNameList", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountNameList(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();
        List<AccountNameNick> jsonResult = accountInfoService.getAccountNameList();
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getaccountinfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        System.out.println(paramJson);

        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        String accountID = (String) object.get("accountID");
        System.out.println("accountInfo " + accountID);

        String result;
        Gson gson = new Gson();

        AccountInfo jsonResult = accountInfoService.getAccountInfo(accountID);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getaccountinfobyidx", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfoByIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        AccountInfo jsonResult = accountInfoService.getAccountInfoByIdx(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertaccountinfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertAccountInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> AccountInfo
            AccountInfo account = mapper.readValue(paramJson.toString(), AccountInfo.class);
            //System.out.printf(" new account: %s %s %s \n", account.accountName, account.accountID, account.accountPW);
            System.out.println(" insert account info: " + account.toString());

            int jsonResult = accountInfoService.insertAccountInfo(account);

            account = accountInfoService.getAccountInfo(account.accountID);
            ;

            BwHistory bwHistory = new BwHistory();
            bwHistory.accountIdx = account.idx;
            bwHistory.weight = account.weight;
            jsonResult = (int) bwHistoryService.insertBwHistory(bwHistory);

            BoxAccountLinkInfo boxAccount = new BoxAccountLinkInfo();
            boxAccount.accountIdx = account.idx;
            boxAccount.boxIdx = 1;// TODO
            jsonResult = (int) boxAccountLinkInfoService.insertBoxAccountLinkInfo(boxAccount);

            PolicyAgreeData agree = new PolicyAgreeData();
            agree.writer = account.idx;
            agree.policyType = 1;
            agree.policyBoardIdx = 1;
            jsonResult = policyAgreeDataService.insertPolicyAgreeData(agree);

            LevelData level = new LevelData();
            level.accountIdx = account.idx;
            level.writer = account.idx;
            level.year = Year.now().getValue();
            jsonResult = levelDataService.insertLevelData(level);

            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }

    @PostMapping(value = "/updateaccountinfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String updateAccountInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        //JSONObject object = (JSONObject) parser.parse(paramJson);

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> AccountInfo
            AccountInfo account = mapper.readValue(paramJson.toString(), AccountInfo.class);
            System.out.println(" update account info: " + account.toString());

            int jsonResult = accountInfoService.updateAccountInfo(account);

            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
/*
    	// 필요값 userID
    	long idx = (long) object.get("idx");
    	String accountPW = (String) object.get("accountPW");
    	String accountNick = (String) object.get("accountNick");
    	String cellNumber = (String) object.get("cellNumber");

    	String zipcode = (String) object.get("zipcode");
    	String address1 = (String) object.get("address1");
    	String address2 = (String) object.get("address2");

    	String height = (String) object.get("height");
    	String weight = (String) object.get("weight");

    	String preferWeight = (String) object.get("preferWeight");

    	String exercisePreferenceMode = (String) object.get("exercisePreferenceMode");

    	String agreeEmail = (String) object.get("agreeEmail");
    	String agreeSms = (String) object.get("agreeSms");
    	String agreePush = (String) object.get("agreePush");

    	Long selCoach = (Long) object.get("selCoach");
    	Long firstMenu = (Long) object.get("firstMenu");

    	String welcomeStr = (String) object.get("welcomeStr");

    	System.out.println("Check idx, accountPW, accountNick, cellNumber, zipcode,address1, address2, height, weight,preferWeight, exercisePreferenceMode, agreeEmail, agreeSms, agreePush, selCoach, welcomeStr, firstMenu");
    	if(selCoach==null && firstMenu==null) {
    		System.out.printf("UPDATE with %d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s \n" , idx, accountPW, accountNick, cellNumber,
    				zipcode,address1, address2, height, weight,preferWeight,
    				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
    				"null", welcomeStr, "null");    	}
    	else if(selCoach==null) {
    		System.out.printf("UPDATE with %d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s \n" , idx, accountPW, accountNick, cellNumber,
    				zipcode,address1, address2, height, weight,preferWeight,
    				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
    				"null", welcomeStr, firstMenu.toString());
    	}
    	else if(firstMenu==null) {
    		System.out.printf("UPDATE with %d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s \n" , idx, accountPW, accountNick, cellNumber,
    				zipcode,address1, address2, height, weight,preferWeight,
    				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
    				selCoach.toString(), welcomeStr, "null");
    	}
    	else {
    		System.out.printf("UPDATE with %d %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s \n" , idx, accountPW, accountNick, cellNumber,
				zipcode,address1, address2, height, weight,preferWeight,
				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
				selCoach.toString(), welcomeStr, firstMenu.toString());
    	}

    	String result;
    	Gson gson = new Gson();
    	int jsonResult = accountInfoService.updateAccountInfo(idx, accountPW, accountNick,
				cellNumber,	zipcode,address1, address2, height, weight, preferWeight,
				exercisePreferenceMode, agreeEmail, agreeSms, agreePush,
				selCoach, welcomeStr, firstMenu);

    	result = gson.toJson(jsonResult);*/

        return result;
    }

    @PostMapping(value = "/loginaccountinfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String loginAccountInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        int jsonResult = accountInfoService.loginAccountInfo(idx);

        System.out.printf("idx %d login, update lastLoginUnixTime\n", idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getaccountinfobyemail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfoByEmailAddress(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값을 get 해서 전달
        String emailAddress = (String) object.get("emailAddress");
        String result;
        Gson gson = new Gson();
        AccountInfo jsonResult = accountInfoService.getAccountInfoByEmail(emailAddress);

        result = gson.toJson(jsonResult);

        return result;
    }


    @PostMapping(value = "/getaccountInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfoAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<AccountInfo> jsonResult = accountInfoService.getAccountInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getaccountInfoLast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getAccountInfoLast(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long start = (long) object.get("start");
        long count = (long) object.get("count");

        String result;
        Gson gson = new Gson();

        List<AccountInfo> jsonResult = accountInfoService.getAccountInfoLast(start, count);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public ActionHistoryService actionHistoryService;


    @PostMapping("/getactionHistory")
    public String getActionHistory(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        ActionHistory jsonResult = actionHistoryService.getActionHistory(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BoxAccountLinkInfoService boxAccountLinkInfoService;


    @PostMapping("/getboxAccountLinkInfo")
    public String getBoxAccountLinkInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        BoxAccountLinkInfo jsonResult = boxAccountLinkInfoService.getBoxAccountLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertboxAccountLinkInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertboxAccountLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            BoxAccountLinkInfo arg = mapper.readValue(paramJson.toString(), BoxAccountLinkInfo.class);
            System.out.println(" insert boxAccountLinkInfo: " + arg.toString());
            int jsonResult = boxAccountLinkInfoService.insertBoxAccountLinkInfo(arg);
            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public BadgeInfoService badgeInfoService;


    @PostMapping(value = "/getbadgeInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getBadgeInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long categoryIdx = (long) object.get("categoryIdx");


        String result;
        Gson gson = new Gson();

        List<BadgeInfo> jsonResult = badgeInfoService.getBadgeInfo(categoryIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BadgeAccountLinkInfoService badgeAccountLinkInfoService;

    @PostMapping(value = "/getbadgeAccountLinkInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getBadgeAccountLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<BadgeAccountLinkInfo> jsonResult = badgeAccountLinkInfoService.getBadgeAccountLinkInfo(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BoxInfoService boxInfoService;


    @PostMapping("/getboxInfo")
    public String getBoxInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        BoxInfo jsonResult = boxInfoService.getBoxInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getboxInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getBoxInfoAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<BoxInfo> jsonResult = boxInfoService.getBoxInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BoxMatchTemplateInfoService boxMatchTemplateInfoService;


    @PostMapping("/getboxMatchTemplateInfo")
    public @ResponseBody String getBoxMatchTemplateInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        BoxMatchTemplateInfo jsonResult = boxMatchTemplateInfoService.getBoxMatchTemplateInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BoxMatchTemplateLinkInfoService boxMatchTemplateLinkInfoService;


    @PostMapping("/getboxMatchTemplateLinkInfo")
    public String getBoxMatchTemplateLinkInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        BoxMatchTemplateLinkInfo jsonResult = boxMatchTemplateLinkInfoService.getBoxMatchTemplateLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public BwHistoryService bwHistoryService;


    @PostMapping("/getbwHistory")
    public String getBwHistory(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        BwHistory jsonResult = bwHistoryService.getBwHistory(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertbwHistory", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertbwHistory(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> bw history
            BwHistory bwHistory = mapper.readValue(paramJson.toString(), BwHistory.class);
            System.out.printf(" new bw: %s \n", bwHistory.weight);

            int jsonResult = (int) bwHistoryService.insertBwHistory(bwHistory);

            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }


    @PostMapping("/getbwHistorWeight")
    public String getBwHistorWeight(

            @RequestBody String paramJson
    ) throws ParseException {


        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);


        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<BwHistory> jsonResult = bwHistoryService.getBwHistorWeight(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public ChatDataMapper chatDataMapper;


    @PostMapping("/getChatData")
    public String getChatData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        ChatData jsonResult = chatDataMapper.getChatData(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getChatDataByAccountIdx")
    public String getChatDataByAccountIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<ChatData> jsonResult = chatDataMapper.getChatDataByAccountIdx(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Operation(summary = "insertChatData chat 추가",
            description = "JSON Ex: {\"accountIdx\":9401, \"msg\": \"chat test123\"} ")
    @PostMapping("/insertChatData")
    public String insertChatData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String msg = (String) object.get("msg");
        String result;
        Gson gson = new Gson();
        ChatData arg = new ChatData();
        arg.accountIdx = (int) accountIdx;
        arg.regAccountIdx = (int) accountIdx;
        arg.msg = msg;
        long jsonResult = chatDataMapper.insertChatData(arg);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public CategoryInfoService categoryInfoService;


    @PostMapping("/getcategoryInfo")
    public String getCategoryInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        CategoryInfo jsonResult = categoryInfoService.getCategoryInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getcategoryInfoBadgeName", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getCategoryInfoBadgeName(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long tableLinkIdx = (long) object.get("tableLinkIdx");

        String result;
        Gson gson = new Gson();

        List<CategoryInfo> jsonResult = categoryInfoService.getCategoryInfoBadgeName(tableLinkIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public CommentDataService commentDataService;


    @PostMapping("/getcommentData")
    public String getCommentData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        CommentData jsonResult = commentDataService.getCommentData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public EventBoardService eventBoardService;


    @PostMapping(value = "/geteventBoard", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getEventBoard(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        EventBoard jsonResult = eventBoardService.getEventBoard(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/geteventBoardAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getEventBoardAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<EventBoard> jsonResult = eventBoardService.getEventBoardAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/geteventBoardLast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getEventBoardLast(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long start = (long) object.get("start");
        long count = (long) object.get("count");

        System.out.printf("start %d count %d\n", start, count);

        String result;
        Gson gson = new Gson();

        List<EventBoard> jsonResult = eventBoardService.getEventBoardLast(start, count);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public FaqBoardService faqBoardService;


    @PostMapping("/getfaqBoard")
    public String getFaqBoard(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        FaqBoard jsonResult = faqBoardService.getFaqBoard(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getfaqBoardAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFaqBoardAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<FaqBoard> jsonResult = faqBoardService.getFaqBoardAll();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public FileDataService fileDataService;


    @PostMapping("/getfileData")
    public String getFileData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        FileData jsonResult = fileDataService.getFileData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getfileDataFile", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFileDataFile(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        String fileKind = (String) object.get("fileKind");
        long tableLinkIdx = (long) object.get("tableLinkIdx");
        long pIdx = (long) object.get("pIdx");


        String result;
        Gson gson = new Gson();

        List<FileData> jsonResult = fileDataService.getFileDataFile(fileKind, tableLinkIdx, pIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getfileDataImage", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFileDataImage(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        String fileKind = (String) object.get("fileKind");
        long tableLinkIdx = (long) object.get("tableLinkIdx");
        long pIdx = (long) object.get("pIdx");


        String result;
        Gson gson = new Gson();

        List<FileData> jsonResult = fileDataService.getFileDataImage(fileKind, tableLinkIdx, pIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    // Mtc -> Mts 오타, 기존 코드를 위해 남김
    @PostMapping(value = "/getfileDataMts", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFileDataMts(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 fileKind, tableLinkIdx, pIdx
        String fileKind = (String) object.get("fileKind");
        long tableLinkIdx = (long) object.get("tableLinkIdx");
        long pIdx = (long) object.get("pIdx");

        String result;
        Gson gson = new Gson();

        List<FileData> jsonResult = fileDataService.getFileDataMtc(fileKind, tableLinkIdx, pIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getfileDataMtc", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFileDataMtc(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 fileKind, tableLinkIdx, pIdx
        String fileKind = (String) object.get("fileKind");
        long tableLinkIdx = (long) object.get("tableLinkIdx");
        long pIdx = (long) object.get("pIdx");

        String result;
        Gson gson = new Gson();

        List<FileData> jsonResult = fileDataService.getFileDataMtc(fileKind, tableLinkIdx, pIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "insertFileData 파일 데이터 추가",
            description = "FileData 모델의 항목 	\r\ntableLinkIdx\r\n"
                    + "	pIdx\r\n"
                    + "	filePath\r\n"
                    + "	fileTitle\r\n"
                    + "	fileNameOrg\r\n"
                    + "	fileNameNew\r\n"
                    + "	fileNameThumb\r\n"
                    + "	fileSize\r\n"
                    + "	fileExt\r\n"
                    + "	fileType\r\n"
                    + "	fileKind\r\n"
                    + "	fileSort\r\n"
                    + "	writer\r\n"
                    + " ")

    @PostMapping(value = "/insertFileData", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertFileData(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        System.out.println(" file data arg: " + object.toString());

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> FileData
            FileData arg = mapper.readValue(paramJson.toString(), FileData.class);
            System.out.printf(" new file: %s \n", arg.toString());

            int jsonResult = (int) fileDataService.insertFileData(arg);

            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return result;
    }


    @Autowired
    public FollowLinkInfoService followLinkInfoService;

    @PostMapping(value = "/getfollowLinkInfoFollow", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFollowLinkInfoFollow(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long followAccountIdx = (long) object.get("followAccountIdx");
        String result;
        Gson gson = new Gson();
        List<FollowLinkInfo> jsonResult = followLinkInfoService.getFollowLinkInfoFollow(followAccountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getfollowLinkInfoReg", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFollowLinkInfoReg(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long regAccountIdx = (long) object.get("regAccountIdx");
        String result;
        Gson gson = new Gson();
        List<FollowLinkInfo> jsonResult = followLinkInfoService.getFollowLinkInfoReg(regAccountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getIsFollow", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getIsFollow(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long regAccountIdx = (long) object.get("regAccountIdx");
        long followAccountIdx = (long) object.get("followAccountIdx");
        String result;
        Gson gson = new Gson();
        FollowLinkInfo arg = new FollowLinkInfo();
        arg.regAccountIdx = (int) regAccountIdx;
        arg.followAccountIdx = (int) followAccountIdx;
        long jsonResult = followLinkInfoService.getIsFollow(arg);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getFollowList", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getFollowList(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<FollowList> jsonResult = followLinkInfoService.getFollowList(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Operation(summary = "insertFollowLinkInfoFollow follow 추가",
            description = "JSON Ex: {\"followAccountIdx\":9401,\"regAccountIdx\": 9402 } ")
    @PostMapping(value = "/insertFollowLinkInfoFollow", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertFollowLinkInfoFollow(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long followAccountIdx = (long) object.get("followAccountIdx");
        long regAccountIdx = (long) object.get("regAccountIdx");
        String result;
        Gson gson = new Gson();
        FollowLinkInfo arg = new FollowLinkInfo();
        arg.followAccountIdx = (int) followAccountIdx;
        arg.regAccountIdx = (int) regAccountIdx;
        long jsonResult = followLinkInfoService.insertFollowLinkInfoFollow(arg);
        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "deleteFollowLinkInfoFollow follow 삭제",
            description = "JSON Ex: {\"followAccountIdx\":9401,\"regAccountIdx\": 9402 } ")
    @PostMapping(value = "/deleteFollowLinkInfoFollow", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String deleteFollowLinkInfoFollow(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long followAccountIdx = (long) object.get("followAccountIdx");
        long regAccountIdx = (long) object.get("regAccountIdx");
        String result;
        Gson gson = new Gson();
        FollowLinkInfo arg = new FollowLinkInfo();
        arg.followAccountIdx = (int) followAccountIdx;
        arg.regAccountIdx = (int) regAccountIdx;
        long jsonResult = followLinkInfoService.deleteFollowLinkInfoFollow(arg);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public GuideBoardService guideBoardService;


    @PostMapping("/getguideBoard")
    public String getGuideBoard(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        GuideBoard jsonResult = guideBoardService.getGuideBoard(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getguideBoardAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getGuideBoardAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<GuideBoard> jsonResult = guideBoardService.getGuideBoardAll();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public InjuryDataService injuryDataService;


    @PostMapping("/getinjuryData")
    public String getInjuryData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        InjuryData jsonResult = injuryDataService.getInjuryData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getinjuryDataLook", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getInjuryDataLook(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        List<InjuryData> jsonResult = injuryDataService.getInjuryDataLook(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getinjuryDataLast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getInjuryDataLast(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        List<InjuryData> jsonResult = injuryDataService.getInjuryDataLast(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertInjuryData", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertInjuryData(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        System.out.println("json " + object.toJSONString());

        String result = "";
        Gson gson = new Gson();

        long accountIdx = (long) object.get("accountIdx");
        long partIdx = (long) object.get("injuryPartIdx");
        long extentIdx = (long) object.get("injuryExtentIdx");
        long treatIdx = (long) object.get("injuryTreatIdx");
        String content = null;
        try {
            content = (String) object.get("content");
        } catch (Exception e) {
            System.out.println(" ex " + e.toString());
        }
        //ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> InjuryData
            InjuryData data = new InjuryData();//mapper.readValue(paramJson.toString(), InjuryData.class);
            data.pIdx = (int) accountIdx;
            data.accountIdx = (int) accountIdx;
            data.writer = (int) accountIdx;
            data.tableLinkIdx = 1; // 고정
            data.status = 1; //고정

            data.injuryPartIdx = (int) partIdx;
            data.injuryExtentIdx = (int) extentIdx;
            data.injuryTreatIdx = (int) treatIdx;
            data.content = content;

            System.out.printf(" new InjuryData: %s \n", data.toString());

            int jsonResult = (int) injuryDataService.insertInjuryData(data);

            result = gson.toJson(jsonResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public InjuryInfoService injuryInfoService;


    @PostMapping("/getinjuryInfo")
    public String getInjuryInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        InjuryInfo jsonResult = injuryInfoService.getInjuryInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getinjuryInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getInjuryInfoAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<InjuryInfo> jsonResult = injuryInfoService.getInjuryInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getinjuryInfoLast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getInjuryInfoLast(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<InjuryInfo> jsonResult = injuryInfoService.getInjuryInfoLast();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public LevelDataService levelDataService;


    @PostMapping("/getlevelData")
    public String getLevelData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        List<LevelData> jsonResult = (List<LevelData>) levelDataService.getLevelData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getlevelDataLevel")
    public String getLevelDataLevel(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long longYear = (long) object.get("year");
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<LevelData> jsonResult = levelDataService.getLevelDataLevel(accountIdx, longYear);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertLevelData", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertLevelData(
            @RequestBody String paramJson
    ) throws ParseException {
        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            LevelData arg = mapper.readValue(paramJson.toString(), LevelData.class);
            System.out.println(" insertPolicyAgreeData: " + arg.toString());
            int jsonResult = levelDataService.insertLevelData(arg);
            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public LikeDataService likeDataService;


    @PostMapping("/getlikeData")
    public String getLikeData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        LikeData jsonResult = likeDataService.getLikeData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MemoDataService memoDataService;


    @PostMapping("/getmemoData")
    public String getMemoData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MemoData jsonResult = memoDataService.getMemoData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MomInfoService momInfoService;

    @PostMapping("/getmomInfo")
    public String getMomInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        MomInfo jsonResult = momInfoService.getMomInfo(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getmomInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMomInfoAll(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<MomInfo> jsonResult = momInfoService.getMomInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getMomInfoListDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMomInfoListDetail(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        List<MomInfoWithFile> jsonResult = momInfoService.getMomInfoListDetail(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getMomTeamInfo")
    public String getMomTeamInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long leaderAccountIdx = (long) object.get("leaderAccountIdx");
        String result;
        Gson gson = new Gson();
        List<MomTeamInfo> jsonResult = momInfoService.getMomTeamInfo(leaderAccountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getMomTeamInfoByMomIdx")
    public String getMomTeamInfoByMomIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long momIdx = (long) object.get("momIdx");
        String result;
        Gson gson = new Gson();
        List<MomTeamInfo> jsonResult = momInfoService.getMomTeamInfoByMomIdx(momIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getMomTeamInfoIdx")
    public String getMomTeamInfoIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long momIdx = (long) object.get("momIdx");
        long leaderAccountIdx = (long) object.get("leaderAccountIdx");
        String result;
        Gson gson = new Gson();
        Long jsonResult = momInfoService.getMomTeamInfoIdx(leaderAccountIdx, momIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "insertMomTeamInfo Team MoM 만들기",
            description = "JSON Ex: { \"momIdx\": 71 , \"accountIdx\": 9401, \"name\": \"Test momTeam name\"} ")
    @PostMapping(value = "/insertMomTeamInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertMomTeamInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> MomTeamInfo
            MomTeamInfo arg = new MomTeamInfo(); // = mapper.readValue(paramJson.toString(), MovementRecordData.class);

            long accountIdx = (long) object.get("accountIdx");
            long momIdx = (long) object.get("momIdx");
            String name = (String) object.get("name");

            arg.momIdx = (int) momIdx;
            arg.leaderAccountIdx = (int) accountIdx;
            arg.regAccountIdx = (int) accountIdx;
            arg.name = name;
            arg.status = 1;

            System.out.printf(" new MomTeamInfo: %s \n", arg.toString());

            int jsonResult = (int) momInfoService.insertMomTeamInfo(arg);

            long momTeamIdx = momInfoService.getMomTeamInfoIdx(accountIdx, momIdx);

            MomTeamMemberInfo arg2 = new MomTeamMemberInfo();
            arg2.momIdx = (int) momIdx;
            arg2.accountIdx = (int) accountIdx;
            arg2.regAccountIdx = (int) accountIdx;
            arg2.status = 1;

            arg2.momTeamIdx = (int) momTeamIdx;
            System.out.printf(" new MomTeamMemberInfo: %s \n", arg2.toString());

            int jsonResult2 = (int) momInfoService.insertMomTeamMemberInfo(arg2);

            result = gson.toJson(jsonResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public MomMovementLinkInfoService momMovementLinkInfoService;


    @PostMapping("/getmomMovementLinkInfo")
    public String getMomMovementLinkInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MomMovementLinkInfo jsonResult = momMovementLinkInfoService.getMomMovementLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MomParticipantLinkInfoService momParticipantLinkInfoService;


    @PostMapping("/getmomParticipantLinkInfo")
    public String getMomParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        MomParticipantLinkInfo jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfo(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "insertMomParticipantLinkInfo MtC 참여하기",
            description = "JSON Ex: { \"momIdx\": 71 , \"accountIdx\": 9401} ")
    @PostMapping("/insertMomParticipantLinkInfo")
    public String insertMomParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        long momIdx = (long) object.get("momIdx");
        String result;
        Gson gson = new Gson();

        MomParticipantLinkInfo arg = new MomParticipantLinkInfo();
        arg.momIdx = (int) momIdx;
        arg.accountIdx = (int) accountIdx;
        arg.writer = (int) accountIdx;
        arg.status = 1;
        long jsonResult = momParticipantLinkInfoService.insertMomParticipantLinkInfo(arg);
        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "deleteMomParticipantLinkInfo MtC 취소하기",
            description = "JSON Ex: { \"momIdx\": 71 , \"accountIdx\": 9401} ")
    @PostMapping("/deleteMomParticipantLinkInfo")
    public String deleteMomParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        long momIdx = (long) object.get("momIdx");
        String result;
        Gson gson = new Gson();

        MomParticipantLinkInfo arg = new MomParticipantLinkInfo();
        arg.momIdx = (int) momIdx;
        arg.accountIdx = (int) accountIdx;
        arg.writer = (int) accountIdx;
        arg.status = 1;
        long jsonResult = momParticipantLinkInfoService.deleteMomParticipantLinkInfo(arg);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getMomParticipantLinkInfoAttend")
    public String getMomParticipantLinkInfoAttend(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        long momIdx = (long) object.get("momIdx");
        MomParticipantLinkInfo arg = new MomParticipantLinkInfo();
        arg.momIdx = (int) momIdx;
        arg.accountIdx = (int) accountIdx;
        String result;
        Gson gson = new Gson();
        long jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfoAttend(arg);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getMomParticipantLinkInfoCount")
    public String getMomParticipantLinkInfoCount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        long jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfoCount(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmomParticipantLinkInfoName", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMomParticipantLinkInfoName(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        System.out.println("getmomParticipantLinkInfoName" + accountIdx);

        String result;
        Gson gson = new Gson();

        List<MomParticipantLinkInfo> jsonResult = momParticipantLinkInfoService.getMomParticipantLinkInfoName(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MomRankDataService momRankDataService;

    @PostMapping("/getmomRankData")
    public String getMomRankData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MomRankData jsonResult = momRankDataService.getMomRankData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    // UTF8 필수, 한글 깨짐
    @Operation(summary = "getMomRankingData MtC 랭킹",
            description = "JSON Ex: { \"momIdx\": 66 , \"year\": 2023, \"start\": 0, \"count\": 15 }"
                    + " \r\n  Option: \"category\":\"gender\", \"filter\":\"W\"  \"category\":\"region\", \"filter\": \"031\"  \"category\":\"age\", \"filter\": \"30\"  \"category\":\"weigth\", \"filter\": \"50\" ")
    @PostMapping(value = "/getMomRankingData", produces = "text/plain;charset=UTF-8")
    public String getMomRankingData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long momIdx = (long) object.get("momIdx");
        long year = (long) object.get("year");
        long start = (long) object.get("start");
        long count = (long) object.get("count");

        String filterStr = "";
        long filterInt = 0;
        String category = "";

        try {
            category = (String) object.get("category");
        } catch (Exception ex) {
            System.out.println("No type or category " + ex.toString());
        }

        System.out.println("category: " + category);

        String result = "";
        Gson gson = new Gson();

        //CategoryInfo category = categoryInfoService.getCategoryInfo(momIdx);
        MomRankData momRankData = momRankDataService.getMomRankData(momIdx);
        List<MomMovementRankInfo> momMovementRankInfoList = momMovementLinkInfoService.getMomMovementRankInfo(momIdx);
        //movementInfoService.getMovementInfo(momIdx);
        int movementCnt = momMovementRankInfoList.size();

        for (int i = 0; i < movementCnt; i++) {
            System.out.println(momMovementRankInfoList.get(i).toString());
        }

        List<MomRankDataResult> list = new ArrayList<>();
        try {
            long movementIdx = momMovementRankInfoList.get(0).movementIdx;
            MovementInfo mvmInfo = movementInfoService.getMovementInfo(movementIdx);
            //long[] movementIdxList = new long[movementCnt];
            MomMovementRankInfo rankInfo = momMovementRankInfoList.get(0);
            String orderType = rankInfo.orderType;// "asc"; // or desc
            String levelField = rankInfo.levelFieldName + "GradeLevel";
            String minMax = "min";

            System.out.println("orderType: " + orderType);
            if (orderType == "desc") {
                minMax = "max";
            }

            if (movementCnt == 1) {
                System.out.println(" movement is only ONE, use grade level " + levelField);
            } else {
                levelField = "totalGradeLevel";
                System.out.println(" movement are MULTIPLE, use grade level " + levelField);
            }
            RankingDataParameter param = new RankingDataParameter();
            param.momIdx = momIdx;
            param.count = count;
            param.start = start;
            param.minMax = minMax;
            param.orderType = orderType;
            param.levelField = levelField;
            param.year = year;
            if ("gender".equals(category)) {
                filterStr = (String) object.get("filter");
                param.gender = filterStr;
                System.out.println("gender filter");
            } else if ("region".equals(category)) {
                filterStr = (String) object.get("filter");
                param.region = filterStr;
                System.out.println("region filter");
            } else if ("age".equals(category)) {
                filterStr = (String) object.get("filter");
                filterInt = Integer.parseInt(filterStr);
                param.age = filterInt;
                System.out.println("age filter");
            } else if ("weight".equals(category)) {
                filterStr = (String) object.get("filter");
                filterInt = Integer.parseInt(filterStr);
                param.weight = filterInt;
                System.out.println("weight filter");
            }

            //System.out.println(param.toString());
            list = momRankDataService.getMomRankingDataList(param);
            //momIdx, levelField, orderType, year, start, count, minMax);
            for (int i = 0; i < list.size(); i++) {
                //System.out.println(list.get(i).toString());
                System.out.println(list.get(i).lfl);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());

        }

        result = gson.toJson(list);

        return result;
    }


    @Autowired
    public MovementInfoService movementInfoService;


    @PostMapping("/getmovementInfo")
    public String getMovementInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MovementInfo jsonResult = movementInfoService.getMovementInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementInfoAll(
    ) throws ParseException {

        String result;
        Gson gson = new Gson();

        List<MovementInfo> jsonResult = movementInfoService.getMovementInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MovementParticipantLinkInfoService movementParticipantLinkInfoService;


    @PostMapping("/getmovementParticipantLinkInfo")
    public String getMovementParticipantLinkInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MovementParticipantLinkInfo jsonResult = movementParticipantLinkInfoService.getMovementParticipantLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MovementPointDataService movementPointDataService;


    @PostMapping("/getmovementPointData")
    public String getMovementPointData(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        MovementPointData jsonResult = movementPointDataService.getMovementPointData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public MovementRecordDataService movementRecordDataService;

    @PostMapping("/getmovementRecordData")
    public String getMovementRecordData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        Gson gson = new Gson();
        List<MovementRecordDataDetail> jsonResult = movementRecordDataService.getMovementRecordData(accountIdx);
        String result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getmovementRecordDataMtcCount")
    public String getmovementRecordDataMtcCount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 momIdx
        long momIdx = (long) object.get("momIdx");
        String result;
        Gson gson = new Gson();
        Long jsonResult = movementRecordDataService.getmovementRecordDataMtcCount(momIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementRecordDataAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataAll(
    ) throws ParseException {
    	/*
    	String hash = BCrypt.hashpw("only4u%!62", "TmekEldhszmfhTmvltdlqslEk");
    	boolean s = BCrypt.checkpw("$2y$12$wmCug.Pp3Abt3Z61236VUet83RJmkOMvLgzbD.9UyQKthJST.K0Vy", hash);

    	System.out.println(hash);
    	System.out.println("match ?" + s);
    	  */
        String result;
        Gson gson = new Gson();
        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataAll();
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getmovementRecordDataRecent", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataRecent(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        System.out.println("getmovementRecordDataRecent" + accountIdx);

        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataRecent(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getmovementRecordDataBest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataBest(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        System.out.println("movementRecord" + accountIdx);

        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataBest(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getmovementRecordDataYearBest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataYearBest(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        long currentYear = (long) object.get("currentYear");

        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataYearBest(accountIdx, currentYear);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementRecordDataDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataDetail(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        long movementIdx = (long) object.get("movementIdx");

        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataDetail(accountIdx, movementIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementRecordDataRecentDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDataRecentDetail(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");
        long movementIdx = (long) object.get("movementIdx");

        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDataRecentDetail(accountIdx, movementIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementRecordDatMomLevel", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDatMomLevel(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDatMomLevel(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getmovementRecordDatChallenge", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMovementRecordDatChallenge(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<MovementRecordData> jsonResult = movementRecordDataService.getMovementRecordDatChallenge(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertRecordData", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertRecordData(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // 필요값: json -> Recorddata
            MovementRecordData arg = new MovementRecordData(); // = mapper.readValue(paramJson.toString(), MovementRecordData.class);

            String accountID = (String) object.get("accountID");
            //long accountIdx = (long) object.get("accountIdx");
            long momIdx = (long) object.get("momIdx");
            long movementIdx = (long) object.get("movementIdx");
            String value = (String) object.get("value");

            long dateYmd = (long) object.get("dateYmd");
            long point = (long) object.get("point");

            String gradeLevel = (String) object.get("gradeLevel");

            //mvLinkIdx, mpLinkIdx,
            AccountInfo ai = accountInfoService.getAccountInfo(accountID);
            //				value, value2, recordType, point, gradeLevel, gender,
            // age, ageGroup, height, heightGroup, weight, weightGroup, region, regionGroup,
            arg.accountIdx = ai.idx;
            arg.gender = ai.gender;
/*
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	Date date = new Date();
        	Date dt = dateFormat.parse(ai.birthday);
        	int age = date.getYear() - dt.getYear() 	;//Integer.parseInt(dateFormat.format(ai.birthday));

        	arg.age = age;
        	*/
            arg.age = ai.getAge();

            arg.ageGroup = ai.ageGroup;
            arg.height = ai.height;
            arg.heightGroup = ai.heightGroup;
            arg.weight = ai.weight;
            arg.weightGroup = ai.weightGroup;
            //arg.region // TODO
            arg.regionGroup = ai.regionGroup;
            arg.momIdx = (int) momIdx;
            arg.movementIdx = (int) movementIdx;

            arg.value = value;
            arg.value2 = value;
            arg.writer = ai.idx;// Account Idx
            arg.status = 1;

            arg.point = (int) point; // Can NOT be null
            arg.dateYmd = (int) dateYmd;
            arg.recordType = 1;
            arg.gradeLevel = gradeLevel;//

            System.out.printf(" new record: %s \n", arg.toString());

            int jsonResult = (int) movementRecordDataService.insertRecordData(arg);

            result = gson.toJson(jsonResult);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public NoticeBoardService noticeBoardService;

    @PostMapping("/getnoticeBoard")
    public String getNoticeBoard(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        NoticeBoard jsonResult = noticeBoardService.getNoticeBoard(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getnoticeBoardAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getNoticeBoardAll(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<NoticeBoard> jsonResult = noticeBoardService.getNoticeBoardAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getnoticeBoardLast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getNoticeBoardLast(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long start = (long) object.get("start");
        long count = (long) object.get("count");

        String result;
        Gson gson = new Gson();

        List<NoticeBoard> jsonResult = noticeBoardService.getNoticeBoardLast(start, count);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getnoticeBoardPopup", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getNoticeBoardPopup() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        long nDay = (long) Long.parseLong(dateFormat.format(date));

        String result;
        Gson gson = new Gson();

        List<NoticeBoard> jsonResult = noticeBoardService.getNoticeBoardPopup(nDay);

        result = gson.toJson(jsonResult);
        return result;
    }

    /*
    @RequestMapping(value = "/admins/promoter/boardmgr/PmtNoticeForm.mwav")
	public ModelAndView insertPmtNtmForm(CommandMap commandMap,
    		HttpServletRequest request, , HttpServletResponse response) throws Exception {

		//ModelAndView 생성
		ModelAndView mv = new ModelAndView("/Admins/Promoter/BoardMgr/PmtNoticeForm");

		//Service를 호출하여 insertPmtNtmForm() 실행
		BoardNoticeAdminsService.insertPmtNtmForm(commandMap.getMap());

		 // 공지사항 등록 후 리스트 화면으로 이동
		response.sendRedirect("/admins/promoter/boardmgr/PmtNoticeList.mwav?pageNum=1");

		// view에 결과 넘김
		return mv;
	}
}*/


    @Autowired
    public PolicyAgreeDataService policyAgreeDataService;

    @PostMapping("/getpolicyAgreeData")
    public String getPolicyAgreeData(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        PolicyAgreeData jsonResult = policyAgreeDataService.getPolicyAgreeData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/insertPolicyAgreeData", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertPolicyAgreeData(
            @RequestBody String paramJson
    ) throws ParseException {
        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            PolicyAgreeData arg = mapper.readValue(paramJson.toString(), PolicyAgreeData.class);
            System.out.println(" insertPolicyAgreeData: " + arg.toString());
            int jsonResult = policyAgreeDataService.insertPolicyAgreeData(arg);
            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Autowired
    public PolicyBoardService policyBoardService;

    @PostMapping("/getpolicyBoard")
    public String getPolicyBoard(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        PolicyBoard jsonResult = policyBoardService.getPolicyBoard(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getpolicyBoardAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getPolicyBoardAll(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 isOpen, policyType
        String isOpen = (String) object.get("isOpen");
        long policyType = (long) object.get("policyType");

        String result;
        Gson gson = new Gson();
        List<PolicyBoard> jsonResult = policyBoardService.getPolicyBoardAll(policyType, isOpen);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public PolicyHistoryService policyHistoryService;

    @PostMapping("/getpolicyHistory")
    public String getPolicyHistory(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        PolicyHistory jsonResult = policyHistoryService.getPolicyHistory(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @Autowired
    public PushBoardService pushBoardService;

    @PostMapping("/getpushBoard")
    public String getPushBoard(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        PushBoard jsonResult = pushBoardService.getPushBoard(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public QnaBoardService qnaBoardService;

    @PostMapping("/getqnaBoard")
    public String getQnaBoard(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        QnaBoard jsonResult = qnaBoardService.getQnaBoard(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public ReportWodItemRecommendService reportWodItemRecommendService;

    @PostMapping("/getreportWodItemRecommend")
    public String getReportWodItemRecommend(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        ReportWodItemRecommend jsonResult = reportWodItemRecommendService.getReportWodItemRecommend(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public ReportWodItemsService reportWodItemsService;

    @PostMapping("/getreportWodItems")
    public String getReportWodItems(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        ReportWodItems jsonResult = reportWodItemsService.getReportWodItems(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public RestAccountInfoService restAccountInfoService;

    @PostMapping("/getrestAccountInfo")
    public String getRestAccountInfo(
            @RequestBody String paramJson
    ) throws ParseException {
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
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값을 get 해서 전달: emailAddress
        String emailAddress = (String) object.get("emailAddress");
        String result;
        Gson gson = new Gson();
        RestAccountInfo jsonResult = restAccountInfoService.getRestAccountInfoByEmail(emailAddress);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public StardionLevelDataService stardionLevelDataService;

    @PostMapping("/getstardionLevelData")
    public String getStardionLevelData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        StardionLevelData jsonResult = stardionLevelDataService.getStardionLevelData(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public TableLinkInfoService tableLinkInfoService;

    @PostMapping("/gettableLinkInfo")
    public String getTableLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        TableLinkInfo jsonResult = tableLinkInfoService.getTableLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public TicketInfoService ticketInfoService;

    @PostMapping("/getticketInfo")
    public String getTicketInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        TicketInfo jsonResult = ticketInfoService.getTicketInfo(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getticketInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getTicketInfoAll(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();
        List<TicketInfo> jsonResult = ticketInfoService.getTicketInfoAll();
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public TicketPaymentDataService ticketPaymentDataService;

    @PostMapping("/getticketPaymentData")
    public String getTicketPaymentData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        TicketPaymentData jsonResult = ticketPaymentDataService.getTicketPaymentData(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getticketPaymentDataBox", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getTicketPaymentDataBox(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        System.out.println("ticketPaymentDataBox" + accountIdx);
        String result;
        Gson gson = new Gson();

        List<TicketPaymentData> jsonResult = ticketPaymentDataService.getTicketPaymentDataBox(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public TokenDataService tokenDataService;

    @PostMapping("/gettokenData")
    public String getTokenData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        TokenData jsonResult = tokenDataService.getTokenData(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public TokenListService tokenListService;


    @PostMapping("/gettokenList")
    public String getTokenList(

            @RequestBody String paramJson
    ) throws ParseException {


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


    @Autowired
    public WithdrawDataService withdrawDataService;


    @PostMapping("/getwithdrawData")
    public String getWithdrawData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WithdrawData jsonResult = withdrawDataService.getWithdrawData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodBoxLinkInfoService wodBoxLinkInfoService;


    @PostMapping("/getwodBoxLinkInfo")
    public String getWodBoxLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodBoxLinkInfo jsonResult = wodBoxLinkInfoService.getWodBoxLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodBoxLinkInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodBoxLinkInfoAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<WodBoxLinkInfo> jsonResult = wodBoxLinkInfoService.getWodBoxLinkInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodBoxLinkInfoByWodIdxArray")
    public String getWodBoxLinkInfoByWodIdx(
            // 인자 전달, Array
//			@RequestBody Long[] arrIdx
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        JSONArray arrBoxIdx = (JSONArray) object.get("arrBoxIdx");
        long accountIdx = (long) object.get("accountIdx");

        // convert json to array
        Long[] arrIdx = new Long[arrBoxIdx.size()];
        for (int i = 0; i < arrBoxIdx.size(); i++) {
            arrIdx[i] = (Long) arrBoxIdx.get(i);
        }

    	/*
    	System.out.println("getwodBoxLinkInfoByWodIdx " + arrIdx);

    	for(int i=0;i<arrIdx.length;i++) {
    		System.out.println("idx? "+arrIdx[i]);
    	}*/

        String result;
        Gson gson = new Gson();

        List<WodBoxLinkInfo> wbliList = wodBoxLinkInfoService.getwodBoxLinkInfoByWodIdx(arrIdx);

        ArrayList<WodBoxInfoTime> infoTimeList = new ArrayList<>();

        for (int i = 0; i < wbliList.size(); i++) {
            Integer wbLinkIdx = wbliList.get(i).idx;
            //System.out.println("wbLinkIdx? " + wbLinkIdx);
            long count = wodParticipantLinkInfoService.getwodParticipantCount(wbLinkIdx);
            long reserved = wodParticipantLinkInfoService.getwodParticipantReserved(wbLinkIdx, accountIdx);
            long status = 0;
            try {
                status = wodParticipantLinkInfoService.getwodParticipantStatus(wbLinkIdx, accountIdx);
            } catch (Exception ex) {
                //System.out.println(ex);
            }


//    		System.out.println("status? " + status);
//    		System.out.println("count  " + count    				+ " limit " + wbliList.get(i).limitCount   				+ " time " + wbliList.get(i).progressTime   				+ " wodidx " + wbliList.get(i).wodIdx    				);
            WodBoxInfoTime infoTime = new WodBoxInfoTime();
            infoTime.count = (int) count;
            infoTime.limitCount = wbliList.get(i).limitCount;
            infoTime.progressTime = wbliList.get(i).progressTime;
            infoTime.wodIdx = wbliList.get(i).wodIdx;
            WodInfo wi = wodInfoService.getWodInfo(infoTime.wodIdx);
            infoTime.name = wi.name;
            infoTime.isOpen = wi.isOpen;
            infoTime.wbLinkIdx = wbliList.get(i).idx;
            infoTime.reserved = (int) reserved;
            infoTime.status = (int) status;

            infoTimeList.add(infoTime);

//    		System.out.println("infoTime: " + infoTime.toString());
        }

        result = gson.toJson(infoTimeList);
        return result;
    }


    @Autowired
    public WodCategoryInfoService wodCategoryInfoService;


    @PostMapping("/getwodCategoryInfo")
    public String getWodCategoryInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodCategoryInfo jsonResult = wodCategoryInfoService.getWodCategoryInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodInfoService wodInfoService;


    @PostMapping("/getwodInfo")
    public String getWodInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodInfo jsonResult = wodInfoService.getWodInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodInfoIdx")
    public String getWodInfoIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 name
        String name = (String) object.get("name");

        String result;
        Gson gson = new Gson();

        long jsonResult = wodInfoService.getWodInfoIdx(name);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodInfoAll(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<WodInfo> jsonResult = wodInfoService.getWodInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/gewodInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String geWodInfoAll(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<WodInfo> jsonResult = wodInfoService.getWodInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodInfoFile", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodInfoFile(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        WodInfoWithFile jsonResult = wodInfoService.getWodInfoFile(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoToday", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String geWodInfoToday(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();
        List<WodInfoWithFile> jsonResult = wodInfoService.getWodInfoToday();
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoTomorrow", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoTomorrow(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoTomorrow();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoPast", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoPast(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoPast();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodInfoTodayByAccount", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String geWodInfoTodayByAccount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<WodInfoWithFile> jsonResult = wodInfoService.getWodInfoTodayByAccount(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodInfoTomorrowByAccount", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoTomorrowByAccount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoTomorrowByAccount(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodInfoPastByAccount", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoPastByAccount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoPastByAccount(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodInfoTodayByBox", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String geWodInfoTodayByBox(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 boxIdx
        long boxIdx = (long) object.get("boxIdx");

        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoTodayByBox(boxIdx);

        System.out.println("size is " + jsonResult.size() + " of boxIdx " + boxIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoTomorrowByBox", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoTomorrowByBox(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 boxIdx
        long boxIdx = (long) object.get("boxIdx");
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoTomorrowByBox(boxIdx);
        System.out.println("size is " + jsonResult.size() + " of boxIdx " + boxIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoPastByBox", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodInfoPastByBox(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 boxIdx
        long boxIdx = (long) object.get("boxIdx");
        String result;
        Gson gson = new Gson();

        List<WodInfoWithFile> jsonResult = wodInfoService.getwodInfoPastByBox(boxIdx);

        System.out.println("size is " + jsonResult.size() + " of boxIdx " + boxIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodInfoClass", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodInfoClass(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<WodInfo> jsonResult = wodInfoService.getWodInfoClass();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodInfoSearch")
    public String getWodInfoSearch(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 keyword
        String keyword = (String) object.get("keyword");

        keyword += "%";//: 뒤에 % 붙여서 사용

        System.out.println("search keyword? " + keyword);

        String result;
        Gson gson = new Gson();

        List<WodInfo> jsonResult = wodInfoService.getwodInfoSearch(keyword);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodInfoSearchName")
    public String getWodInfoSearchName(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 keyword
        String keyword = (String) object.get("keyword");

        keyword += "%";//: 뒤에 % 붙여서 사용

        System.out.println("search keyword? " + keyword);

        String result;
        Gson gson = new Gson();

        List<String> jsonResult = wodInfoService.getwodInfoSearchName(keyword);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodInfoSearchNameIdx")
    public String getWodInfoSearchNameIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 keyword
        String keyword = (String) object.get("keyword");

        keyword += "%";//: 뒤에 % 붙여서 사용

        System.out.println("search keyword? " + keyword);

        String result;
        Gson gson = new Gson();

        List<WodInfoNameIdx> jsonResult = wodInfoService.getwodInfoSearchNameIdx(keyword);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodInfoSearchYear")
    public String getWodInfoSearchYear(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 keyword
        String keyword = (String) object.get("keyword");
        keyword += "%";//: 뒤에 % 붙여서 사용
        System.out.println("search keyword? " + keyword);
        String result;
        Gson gson = new Gson();
        List<WodInfo> jsonResult = wodInfoService.getWodInfoSearchYear(keyword);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItem3RmDataService wodItem3RmDataService;


    @PostMapping("/getwodItem3RmData")
    public String getWodItem3RmData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodItem3RmData jsonResult = wodItem3RmDataService.getWodItem3RmData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItem3RmDataPersonalDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItem3RmDataPersonalDetail(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<WodItem3RmData> jsonResult = wodItem3RmDataService.getWodItem3RmDataPersonalDetail(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItem5RmDataService wodItem5RmDataService;


    @PostMapping("/getwodItem5RmData")
    public String getWodItem5RmData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodItem5RmData jsonResult = wodItem5RmDataService.getWodItem5RmData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItem5RmDataPersonalDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItem5RmDataPersonalDetail(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long accountIdx = (long) object.get("accountIdx");


        String result;
        Gson gson = new Gson();

        List<WodItem5RmData> jsonResult = wodItem5RmDataService.getWodItem5RmDataPersonalDetail(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItemCategoryInfoService wodItemCategoryInfoService;


    @PostMapping("/getwodItemCategoryInfo")
    public String getWodItemCategoryInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodItemCategoryInfo jsonResult = wodItemCategoryInfoService.getWodItemCategoryInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItemInfoService wodItemInfoService;


    @PostMapping("/getwodItemInfo")
    public String getWodItemInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodItemInfo jsonResult = wodItemInfoService.getWodItemInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemInfoAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemInfoAll(
    ) throws ParseException {

        String result;
        Gson gson = new Gson();

        List<WodItemInfo> jsonResult = wodItemInfoService.getWodItemInfoAll();

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItemOneRmDataService wodItemOneRmDataService;


    @PostMapping("/getwodItemOneRmData")
    public String getWodItemOneRmData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        WodItemOneRmData jsonResult = wodItemOneRmDataService.getWodItemOneRmData(idx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemOneRmDataPersonal", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataPersonal(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataPersonal(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodItemOneRmDataPoundHistory", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataPoundHistory(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemOneRmDataHistory> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataPoundHistory(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemOneRmDataPersonalDetail", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataPersonalDetail(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataPersonalDetail(accountIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemOneRmDataClub", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataClub(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataClub(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodItemOneRmPoundClubByGender", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmPoundClubByGender(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 gender
        String gender = (String) object.get("gender");
        String result;
        Gson gson = new Gson();

        List<NumbersRankDataIdx> rankIdxs = wodItemOneRmDataService.getWodItemOneRmPoundClubByGender(gender);
        ArrayList<NumbersRankData> jsonResult = new ArrayList<>();
        for (int i = 0; i < rankIdxs.size(); i++) {
            NumbersRankData data = wodItemOneRmDataService.getNumbersRankData(rankIdxs.get(i).accountIdx);
            data.total = rankIdxs.get(i).total;
            if (data.backSquat == null) {
                data.backSquat = wodItemOneRmDataService.getNumbersRankDataSquat(rankIdxs.get(i).accountIdx);
            }
            if (data.benchPress == null) {
                data.benchPress = wodItemOneRmDataService.getNumbersRankDataBenchPress(rankIdxs.get(i).accountIdx);
            }
            if (data.deadLift == null) {
                data.deadLift = wodItemOneRmDataService.getNumbersRankDataDeadLift(rankIdxs.get(i).accountIdx);
            }

            jsonResult.add(data);
        }

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodItemOneRmDataClubMan", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataClubMan(
    ) throws ParseException {
        String result;
        Gson gson = new Gson();

        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataClubMan();

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemOneRmDataClubWoman", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataClubWoman(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataClubWoman();

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodItemOneRmDataClubAll", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemOneRmDataClubAll(
    ) throws ParseException {


        String result;
        Gson gson = new Gson();

        List<WodItemOneRmData> jsonResult = wodItemOneRmDataService.getWodItemOneRmDataClubAll();

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodItemRmData")
    public String getWodItemRmData(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 accountIdx, rmType
        long accountIdx = (long) object.get("accountIdx");
        String rmType = (String) object.get("rmType");

        String result;
        Gson gson = new Gson();
        if ("wodItemOneRmData".equals(rmType)
                || "wodItem3RmData".equals(rmType)
                || "wodItem5RmData".equals(rmType)) {
            List<WodItemRmData> jsonResult = wodItemOneRmDataService.getWodItemRmData(rmType, accountIdx);

            result = gson.toJson(jsonResult);
        } else {
            result = "Error RM TYPE " + rmType;
        }

        return result;
    }

    @PostMapping(value = "/insertPersonalBest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String insertPersonalBest(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long idx = (long) object.get("accountIdx");
        int accountIdx = (int) idx;
        String rmType = (String) object.get("rmType");
        long wodItemIdx = (long) object.get("wodItemIdx");

        String result;
        Gson gson = new Gson();
        String lb = (String) object.get("lb");
        // TODO: 디자인에는 있으나 사용할 필요 불명
        //String strTime = (String) object.get("strTime");    	String strDate = (String) object.get("strDate");

        if ("wodItemOneRmData".equals(rmType)
                || "wodItem3RmData".equals(rmType)
                || "wodItem5RmData".equals(rmType)) {

            WodItemInsertRmData arg = new WodItemInsertRmData();
            arg.accountIdx = accountIdx;
            arg.value2 = lb;
            double lbs = Double.parseDouble(lb);
            //kg = lbs / 2.20462
            double kg = lbs / 2.20462;
            arg.value = String.format("%.1f", kg);    //.valueOf(kg);

            arg.rmType = rmType;

            arg.writer = accountIdx;
            arg.status = 1;
            arg.recordUnit = 2; // TODO, fixed 2 for now
            arg.recordType = 1; // TODO, fixed 1 for now
    		/*
    		 * - wodItemIdx : 아래 변수 참조 (각 운동 item의 0번째 숫자)
const myPBCategoryList = [
	[15, ＇Deadlift＇],
	[12, ＇Back Squat＇],
	[11, ＇Front Squat＇],
	[23, ＇Overhead Squat＇],
	[4, ＇Bench Press＇],
	[35, ＇Clean & Jerk＇],
	[25, ＇Clean＇],
	[14, ＇Snatch＇],
	[7, ＇Push Press＇],
	[3, ＇Push Jerk＇]
];
    		 */
            arg.wodItemIdx = (int) wodItemIdx;// TODO, test 15

            System.out.println("arg: " + arg.toString());

            int jsonResult = (int) wodItemOneRmDataService.insertPersonalBest(arg);

            result = gson.toJson(jsonResult);
        } else {
            result = "Error RM TYPE " + rmType;
        }

        return result;
    }


    @Autowired
    public WodItemRankDataService wodItemRankDataService;


    @PostMapping("/getwodItemRankData")
    public String getWodItemRankData(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodItemRankData jsonResult = wodItemRankDataService.getWodItemRankData(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodItemRecordDataService wodItemRecordDataService;

    @Operation(summary = "getWodItemRecordDataDetail 해당 계정의 기록",
            description = "JSON Ex: { \"accountIdx\":9401 } ")
    @PostMapping("/getWodItemRecordDataDetail")
    public String getWodItemRecordDataDetail(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 accountIdx
        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        List<WodItemRecordDataDetail> jsonResult = wodItemRecordDataService.getWodItemRecordDataDetail(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodItemRecordDataByWodIdx")
    public String getwodItemRecordDataByWodIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordDataByWodIdx(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getWodItemRecordDataRankingByWodIdx", produces = "text/plain;charset=UTF-8")
    public String getWodItemRecordDataRankingByWodIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        Gson gson = new Gson();

        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordDataByWodIdx(wodIdx);
        int n = jsonResult.size();
        ArrayList<WodItemRecordDataRanking> rankingList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            WodItemRecordData item = jsonResult.get(i);
            WodItemRecordDataRanking data = new WodItemRecordDataRanking();
            data.accountIdx = item.accountIdx;
            data.boxIdx = item.boxIdx;
            data.gender = item.gender;
            data.recordType = item.recordType;
            data.recordUnit = item.recordUnit;
            data.value = item.value;
            data.value2 = item.value2;
            data.wodRecordIdx = item.wodRecordIdx;
            data.wodStepIdx = item.wodStepIdx;
            data.wbLinkIdx = item.wbLinkIdx;

            String path = "";
            List<FileData> pathList = fileDataService.getFileDataImage("C", 1, item.accountIdx);
            if (pathList.size() > 0) {
                path = pathList.get(0).filePath + "/" + pathList.get(0).fileNameThumb;
            }
            data.profileImagePath = path;

            AccountInfo info = accountInfoService.getAccountInfoByIdx(item.accountIdx);
            // Null 체크 및 안전한 대입
            data.accountNick = (info != null && info.accountNick != null) ? info.accountNick : "-";
            rankingList.add(data);
            //System.out.println("rank data: "+i + " " + data.toString());

        }

        String result = gson.toJson(rankingList);
        return result;
    }

    @PostMapping("/getwodItemRecordDataByWodAvg")
    public String getwodItemRecordDataByWodAvg(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        Double jsonResult = wodItemRecordDataService.getWodItemRecordDataByWodAvg(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodItemRecordDataByWodBest")
    public String getwodItemRecordDataByWodBest(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String minMax = (String) object.get("minMax");
        System.out.println("minMax: " + minMax);

        String result;
        Gson gson = new Gson();
        Double jsonResult = wodItemRecordDataService.getWodItemRecordDataByWodBest(wodIdx, minMax);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodItemRecordListByWodIdx")
    public String getWodItemRecordListByWodIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordListByWodIdx(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodItemRecordRankingList")
    public String getWodItemRecordRankingList(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        long start = (long) object.get("start");
        long count = (long) object.get("count");
        String orderType = (String) object.get("orderType");

        String filterStr = "";
        long filterInt = 0;
        String category = "";

        try {
            category = (String) object.get("category");
        } catch (Exception ex) {
            System.out.println("No type or category " + ex.toString());
        }
        System.out.println("category: " + category);

        RankingDataParameter param = new RankingDataParameter();
        param.wodIdx = wodIdx;
        param.count = count;
        param.start = start;
        param.orderType = orderType;
        if ("gender".equals(category)) {
            param.gender = filterStr;
            System.out.println("gender filter");
        } else if ("box".equals(category)) {
            filterStr = (String) object.get("box");
            filterInt = Integer.parseInt(filterStr);
            param.boxIdx = filterInt;
            System.out.println("box filter");
        } else if ("scale".equals(category)) {
            filterStr = (String) object.get("scales");
            filterInt = Integer.parseInt(filterStr);
            param.boxIdx = filterInt;
            System.out.println("box filter");
        }
        System.out.println(param.toString());

        String result;
        Gson gson = new Gson();
        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordRankingList(param);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping("/getRankingBest")
    public String getWodItemRecordDataBest(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");

        String result;
        Gson gson = new Gson();

        long jsonResult = wodItemRecordDataService.getWodItemRecordDataBest(wodIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getRankingScale")
    public String getRankingScale(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getRankingScale(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getRankingScaleString")
    public String getRankingScaleString(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<String> jsonResult = wodItemRecordDataService.getRankingScaleString(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getRankingScaleGender")
    public String getRankingScaleGender(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<ScaleGender> jsonResult = wodItemRecordDataService.getRankingScaleGender(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodItemRecordDataRecent", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemRecordDataRecent(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordDataRecent(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/getwodItemRecordDatarecord", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getWodItemRecordDatarecord(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();
        List<WodItemRecordData> jsonResult = wodItemRecordDataService.getWodItemRecordDatarecord(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    // rrrr
    @PostMapping("/insertWodItemRecord")
    public String insertWodItemRecord(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        long accountIdx = (long) object.get("accountIdx");
        long boxIdx = (long) object.get("boxIdx");
        long wodIdx = (long) object.get("wodIdx");
        long wodStepIdx = (long) object.get("wodStepIdx");

        long wbLinkIdx = (long) object.get("wbLinkIdx");
        // wodRecordInfo idx
        long wodRecordInfoIdx = (long) object.get("wodRecordInfoIdx");

        long recordType = (long) object.get("recordType");
        long recordUnit = (long) object.get("recordUnit");

        long dateYmd = (long) object.get("dateYmd");
        String value = (String) object.get("value");
        String value2 = (String) object.get("value2");
        String result;
        Gson gson = new Gson();

        int jsonResult = 0;
        try {
            WodItemRecordData arg = new WodItemRecordData();
            arg.accountIdx = (int) accountIdx;


            //mvLinkIdx, mpLinkIdx,
            AccountInfo ai = accountInfoService.getAccountInfoByIdx(accountIdx);
            arg.accountIdx = ai.idx;
            arg.gender = ai.gender;

            arg.age = ai.getAge();

            arg.ageGroup = ai.ageGroup;
            arg.height = ai.height;
            arg.heightGroup = ai.heightGroup;
            arg.weight = ai.weight;
            arg.weightGroup = ai.weightGroup;
            //arg.region // TODO
            arg.regionGroup = ai.regionGroup;
            arg.writer = ai.idx;// Account Idx
            arg.status = 1;

            arg.dateYmd = (int) dateYmd;

            arg.isOneRm = "N";

            arg.recordType = (int) recordType;
            arg.recordUnit = (int) recordUnit;

            arg.boxIdx = (int) boxIdx;
            arg.wodIdx = (int) wodIdx;
            arg.wbLinkIdx = (int) wbLinkIdx;
            arg.wodStepIdx = (int) wodStepIdx;
            arg.wodRecordIdx = (int) wodRecordInfoIdx;

            if (recordType == 2 && recordUnit == 4) {
                arg.value = value;
                arg.value2 = value2;
            } else {
                if (recordType == 1 && recordUnit == 1) { // kg, lbs
                    arg.value = value;
                    arg.value2 = kgToLbs(value);
                } else {
                    arg.value = value;
                    arg.value2 = value2;
                }
            }

//        	System.out.println("insertWodItemRecord: " + arg.toString());

            jsonResult = (int) wodItemRecordDataService.insertWodItemRecord(arg);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodParticipantLinkInfoService wodParticipantLinkInfoService;

    @Operation(summary = "getRangedWodParticipantLinkInfo 와드 참/불참 기간별 조회",
            description = "JSON Ex: { \"accountIdx\":9401, \"start\":\"2024-09-01\", \"end\":\"2024-10-04\" } ")
    @PostMapping("/getRangedWodParticipantLinkInfo")
    public String getRangedWodParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        String result = "";
        Gson gson = new Gson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            RangedArg arg = mapper.readValue(paramJson.toString(), RangedArg.class);
            System.out.printf("args start/end: %s \n", arg.toString());

            MomAttend jsonResult = wodParticipantLinkInfoService.getRangedWodParticipantLinkInfo(arg);
            if (jsonResult == null) {
                jsonResult = new MomAttend();
                jsonResult.attend = 0;
                jsonResult.noAttend = 0;
            }
            result = gson.toJson(jsonResult);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    	/*
    	long accountIdx = (long) object.get("accountIdx");
    	String start = (String) object.get("start");
    	String end = (String) object.get("end");

    	String result;
    	Gson gson = new Gson();
    	MomAttend a = new MomAttend();
    	a.attend = 10;
    	a.noAttend = 20;
    	result = gson.toJson(a);



    	*/
        return result;
    }

    @Operation(summary = "getRangedWodParticipantLinkInfoMap 기간 내 와드 참/불참 기록 리스트 조회",
            description = "JSON Ex: { \"accountIdx\":104, \"start\":\"2024-09-01\", \"end\":\"2024-10-04\" } ")
    @PostMapping("/getRangedWodParticipantLinkInfoMap")
    public String getRangedWodParticipantLinkInfoMap(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new Gson();
        String result = "";
        try {
            RangedArg arg = mapper.readValue(paramJson.toString(), RangedArg.class);
            System.out.printf("args start/end: %s \n", arg.toString());

            List<MomAttendByDay> jsonResult = wodParticipantLinkInfoService.getRangedWodParticipantLinkInfoMap(arg);

            if (jsonResult == null) {
                result = gson.toJson(jsonResult);
            } else {
                JsonObject jsonObject = new JsonObject();
                int[] arr1 = {2, 1};
                //	    	jsonObject.add("20240821", gson.toJsonTree(arr1));
                for (int i = 0; i < jsonResult.size(); i++) {
                    arr1[0] = jsonResult.get(i).attend;
                    arr1[1] = jsonResult.get(i).noAttend;
                    jsonObject.add(jsonResult.get(i).dateAttend, gson.toJsonTree(arr1));
                }
                result = gson.toJson(jsonObject);
            }
        } catch (JsonProcessingException e) {
            result = e.toString();
            e.printStackTrace();
        }


        return result;
    }

    @Operation(summary = "getRangedMomStatSummary 기간 내 몸스터 참여 관련 정보 조회, 현재 테스트 모드 항상 같은 값 반환",
            description = "JSON Ex: { \"accountIdx\":9401, \"start\":\"2024-09-01\", \"end\":\"2024-10-04\" } ")
    @PostMapping("/getRangedMomStatSummary")
    public String getRangedMomStatSummary(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String start = (String) object.get("start");
        String end = (String) object.get("end");

        String result;
        Gson gson = new Gson();

        MomSummary momSummary = new MomSummary();
        momSummary.attend = 10;
        momSummary.avgRank = 3.1;
        momSummary.avgRecord = 20.2;
        result = gson.toJson(momSummary);
        return result;
    }

    @Operation(summary = "getRangedMyMomHistory 기간 내 참여한 몸스터 기록 조회, 현재 테스트 모드 같은 값 반환",
            description = "JSON Ex: { \"accountIdx\":9401, \"start\":\"2024-09-01\", \"end\":\"2024-10-04\" } ")
    @PostMapping("/getRangedMyMomHistory")
    public String getRangedMyMomHistory(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String start = (String) object.get("start");
        String end = (String) object.get("end");

        String result;
        Gson gson = new Gson();


        MomHistory h1 = new MomHistory();
        h1.title = "test MTC";
        h1.bestRecord = 20.0;
        h1.myRank = 10;
        h1.participantCount = 50;
        h1.myRecord = 30.3;

        MomHistory h2 = new MomHistory();

        h2.title = "MTC 10";
        h2.bestRecord = 12.1;
        h2.myRank = 3;
        h2.participantCount = 45;
        h2.myRecord = 22.1;

        List<MomHistory> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);

        result = gson.toJson(list);
        return result;
    }

    @PostMapping("/getwodParticipantLinkInfo")
    public String getWodParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodParticipantLinkInfo jsonResult = wodParticipantLinkInfoService.getWodParticipantLinkInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodParticipantLinkInfoAttend", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodParticipantLinkInfoAttend(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        String result;
        Gson gson = new Gson();

        long jsonResult = wodParticipantLinkInfoService.getwodParticipantLinkInfoAttend(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodParticipantCount")
    public String getwodParticipantCount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wbLinkIdx
        long wbLinkIdx = (long) object.get("wbLinkIdx");

        String result;
        Gson gson = new Gson();

        Long jsonResult = wodParticipantLinkInfoService.getwodParticipantCount(wbLinkIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/getwodParticipantLinkInfoNoAttend", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getwodParticipantLinkInfoNoAttend(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 accoutIdx
        long accountIdx = (long) object.get("accountIdx");

        String result;
        Gson gson = new Gson();

        long jsonResult = wodParticipantLinkInfoService.getwodParticipantLinkInfoNoAttend(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @RestController
    public class RunQueryController {

        private final JdbcTemplate jdbcTemplate;

        // JdbcTemplate을 생성자 주입
        public RunQueryController(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @PostMapping("/runQuery")
        public ResponseEntity<?> runQuery(@RequestBody SqlVO sqlVO) {
            String query = sqlVO.getquery().toString();  // 쿼리 파라미터 추출
            System.out.println("Received Query: " + query);

            try {
                // 쿼리 실행 및 결과를 가져옴
                List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
                return ResponseEntity.ok(result);  // JSON 형태로 반환
            } catch (Exception e) {
                // 오류 처리
                System.err.println("Error executing query: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    }

//    @Operation(summary = "runQuery 동적 쿼리",
//    		description = "JSON Ex: {\r\n"
//    				+ "  \"query\": \"SELECT * FROM stadion_db_dev.wodParticipantLinkInfo where idx =1\"\r\n"
//    				+ "} ")
//    @PostMapping("/runQuery")
//	public String runQuery(
//			@RequestBody SqlVO param
//			) throws ParseException {
//
//    	String result = "";
//    	Gson gson = new Gson();
//    	System.out.println("param? " + param.toString());
//
//    	try {
//
//    		LinkedHashMap retMap = wodParticipantLinkInfoService.runWodQuery(param);
//    		result = gson.toJson(retMap);
//    	}
//    	catch(Exception exStatus) {
//    		System.out.println(exStatus.toString());
//    		System.out.println("NO result");
//    	}
//
//    	return result;
//	}


    @Operation(summary = "insertwodParticipantLinkInfo wod예약 추가(insert), 기존 데이터 존재할 경우 status 9로 updqte",
            description = "JSON Ex: { \"writer\":9401, \"wodIdx\":7121, \"boxIdx\":1, \"wbLinkIdx\":34979 } ")
    @PostMapping("/insertwodParticipantLinkInfo")
    public String insertWodParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wodIdx, boxIdx, writer, wbLinkIdx
        long wodIdx = (long) object.get("wodIdx");
        long boxIdx = (long) object.get("boxIdx");
        long writer = (long) object.get("writer");
        long wbLinkIdx = (long) object.get("wbLinkIdx");

        String result;
        Gson gson = new Gson();

        long jsonResult = 0;
        long dataStatus = 0;
        long idx = 0;
        try {
            dataStatus = wodParticipantLinkInfoService.getWodParticipantStatus(writer, wbLinkIdx);
            idx = wodParticipantLinkInfoService.getwodParticipantIdx(writer, wbLinkIdx);
        } catch (Exception exStatus) {
            System.out.println("NO reservation data, INSERT IT"); //exStatus.toString());
            dataStatus = 0;
            idx = 0;
        }
        try {
            if (dataStatus == 9) { // reserve again: status 9 -> 1
                jsonResult = wodParticipantLinkInfoService.reserveWodParticipantLinkInfo(idx);
                System.out.println("re-reserveWodParticipantLinkInfo: " + idx);
            } else if (dataStatus == 1) { //cancel: status 1 -> 9
                jsonResult = wodParticipantLinkInfoService.cancelWodParticipantLinkInfo(idx);
                System.out.println("cancel WodParticipantLinkInfo: " + idx);
            } else if (dataStatus == 0) {
                WodParticipantLinkInfo arg = new WodParticipantLinkInfo();
                arg.wodIdx = (int) wodIdx;
                arg.boxIdx = (int) boxIdx;
                arg.accountIdx = (int) writer;
                arg.writer = (int) writer;
                arg.status = 1;
                arg.wbLinkIdx = (int) wbLinkIdx;
                System.out.println("insertWodParticipantLinkInfo: " + arg.toString());
                jsonResult = wodParticipantLinkInfoService.insertWodParticipantLinkInfo(arg);
            } else {
                System.out.println("SKIP insertWodParticipantLinkInfo, status is not 9 ");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            jsonResult = 0;
        }

        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping(value = "/cancelwodParticipantLinkInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String cancelWodParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wbLinkIdx, accountIdx
        long accountIdx = (long) object.get("accountIdx");
        long wbLinkIdx = (long) object.get("wbLinkIdx");

        long idx = wodParticipantLinkInfoService.getwodParticipantIdx(accountIdx, wbLinkIdx);

        String result;
        Gson gson = new Gson();

        long jsonResult = 0;
        try {
            jsonResult = wodParticipantLinkInfoService.cancelWodParticipantLinkInfo(idx);
        } catch (Exception e) {
            System.out.println(e.toString());
            jsonResult = 0;
        }

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping(value = "/reservewodParticipantLinkInfo", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String reserveWodParticipantLinkInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wbLinkIdx, accountIdx
        long accountIdx = (long) object.get("accountIdx");
        long wbLinkIdx = (long) object.get("wbLinkIdx");

        long idx = wodParticipantLinkInfoService.getwodParticipantIdx(accountIdx, wbLinkIdx);

        String result;
        Gson gson = new Gson();

        long jsonResult = 0;
        try {
            jsonResult = wodParticipantLinkInfoService.reserveWodParticipantLinkInfo(idx);
        } catch (Exception e) {
            System.out.println(e.toString());
            jsonResult = 0;
        }

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodParticipantIdx")
    public String getwodParticipantIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wbLinkIdx, accountIdx
        long accountIdx = (long) object.get("accountIdx");
        long wbLinkIdx = (long) object.get("wbLinkIdx");

        String result;
        Gson gson = new Gson();

        Long jsonResult = wodParticipantLinkInfoService.getwodParticipantIdx(accountIdx, wbLinkIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodParticipantCountByAccount")
    public String getWodParticipantCount(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wodIdx, accountIdx
        long accountIdx = (long) object.get("accountIdx");
        long wodIdx = (long) object.get("wodIdx");

        String result;
        Gson gson = new Gson();

        Long jsonResult = wodParticipantLinkInfoService.getWodParticipantCountByAccount(accountIdx, wodIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getwodParticipantRecent")
    public String getwodParticipantRecent(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값  accountIdx
        long accountIdx = (long) object.get("accountIdx");
        //long wbLinkIdx = (long) object.get("wbLinkIdx");

        String result;
        Gson gson = new Gson();

        WodBoxLinkInfoName jsonResult = wodParticipantLinkInfoService.getwodParticipantRecent(accountIdx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWbLinkIdx")
    public String getWbLinkIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        long accountIdx = (long) object.get("accountIdx");
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        try {
            long jsonResult = wodParticipantLinkInfoService.getWbLinkIdx(accountIdx, wodIdx);
            result = gson.toJson(jsonResult);
        } catch (Exception e) {
            result = gson.toJson(0);
        }
        return result;
    }


    @PostMapping("/getWodRankingAttend")
    public String getWodParticipantAttend(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");

        String result;
        Gson gson = new Gson();
        Long jsonResult = wodParticipantLinkInfoService.getWodParticipantAttend(wodIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodRecordInfoService wodRecordInfoService;

    @PostMapping("/getwodRecordInfo")
    public String getWodRecordInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 idx
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodRecordInfo jsonResult = wodRecordInfoService.getWodRecordInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

    @Operation(summary = "WodRecordInfo 조회", description = "wodIdx로 WodRecordInfo를 조회")
    @PostMapping("/getWodRecordInfoByWodIdx")
    public String getWodRecordInfoByWodIdx(
            @Parameter(description = WOD_IDX)
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");

        String result;
        Gson gson = new Gson();

        List<WodRecordInfo> jsonResult = wodRecordInfoService.getWodRecordInfoByWodIdx(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @PostMapping("/getWodRecordInfoRecentByWod")
    public String getWodRecordInfoRecentByWod(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값  accountIdx
        long accountIdx = (long) object.get("accountIdx");
        long wodIdx = (long) object.get("wodIdx");

        String result;
        Gson gson = new Gson();

        List<WodRecordInfoWithBox> jsonResult = wodRecordInfoService.getWodRecordInfoRecentByWod(accountIdx, wodIdx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodRoundInfoService wodRoundInfoService;


    @PostMapping("/getwodRoundInfo")
    public String getWodRoundInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodRoundInfo jsonResult = wodRoundInfoService.getWodRoundInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodRoundItemInfoService wodRoundItemInfoService;


    @PostMapping("/getwodRoundItemInfo")
    public String getWodRoundItemInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodRoundItemInfo jsonResult = wodRoundItemInfoService.getWodRoundItemInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodStepInfoService wodStepInfoService;

    @PostMapping("/getwodStepInfo")
    public String getWodStepInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 idx
        long idx = (long) object.get("idx");
        String result;
        Gson gson = new Gson();
        WodStepInfo jsonResult = wodStepInfoService.getWodStepInfo(idx);
        result = gson.toJson(jsonResult);
        return result;
    }

    @PostMapping("/getWodStepInfoByWodIdx")
    public String getWodStepInfoByWodIdx(
            @RequestBody String paramJson
    ) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);
        // 필요값 wodIdx
        long wodIdx = (long) object.get("wodIdx");
        String result;
        Gson gson = new Gson();
        List<WodStepInfo> jsonResult = wodStepInfoService.getWodStepInfoByWodIdx(wodIdx);
        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodTemplateInfoService wodTemplateInfoService;

    @PostMapping("/getwodTemplateInfo")
    public String getWodTemplateInfo(
            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodTemplateInfo jsonResult = wodTemplateInfoService.getWodTemplateInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodTemplateRecordInfoService wodTemplateRecordInfoService;


    @PostMapping("/getwodTemplateRecordInfo")
    public String getWodTemplateRecordInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodTemplateRecordInfo jsonResult = wodTemplateRecordInfoService.getWodTemplateRecordInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodTemplateRoundInfoService wodTemplateRoundInfoService;


    @PostMapping("/getwodTemplateRoundInfo")
    public String getWodTemplateRoundInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodTemplateRoundInfo jsonResult = wodTemplateRoundInfoService.getWodTemplateRoundInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodTemplateRoundItemInfoService wodTemplateRoundItemInfoService;


    @PostMapping("/getwodTemplateRoundItemInfo")
    public String getWodTemplateRoundItemInfo(

            @RequestBody String paramJson
    ) throws ParseException {


        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodTemplateRoundItemInfo jsonResult = wodTemplateRoundItemInfoService.getWodTemplateRoundItemInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }


    @Autowired
    public WodTemplateStepInfoService wodTemplateStepInfoService;


    @PostMapping("/getwodTemplateStepInfo")
    public String getWodTemplateStepInfo(
            @RequestBody String paramJson
    ) throws ParseException {
        // 들어온 인자 json에서 Mapper 쿼리로 전달할 내용 파싱
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(paramJson);

        // 필요값 userID
        long idx = (long) object.get("idx");

        String result;
        Gson gson = new Gson();

        WodTemplateStepInfo jsonResult = wodTemplateStepInfoService.getWodTemplateStepInfo(idx);

        result = gson.toJson(jsonResult);
        return result;
    }

}