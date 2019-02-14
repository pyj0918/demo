package com.ylink.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;
import com.ylink.entity.Fee;
import com.ylink.entity.MerchantAddRequest;
import com.ylink.entity.MerchantQueryResponse;
import com.ylink.entity.Payment;
import com.ylink.entity.Response;
import com.ylink.entity.SettleAccountInfo;
import com.ylink.utils.HttpClientUtil;
import com.ylink.utils.JsonUtils;
import com.ylink.utils.SignUtil;
import com.ylink.utils.StaticConfig;

/**
 * 网关商户请求
 */
public class MerchantAddDemo extends BaseDemo {
	private static Logger logger = LoggerFactory.getLogger(MerchantAddDemo.class);
	
	// -----------------------------------merchantQuery begin--------------------------------------------------------
	public void merchantAdd(MerchantAddRequest request) {
		try {
			Map<String, String> param = SignUtil.assignment("1001", request, StaticConfig.MERCHANT_PRIVATE_KEY, StaticConfig.ACCESS_NO);
			String json = HttpClientUtil.sendPostString(StaticConfig.GATEWAY_URL, param);
			
			Response respone = process(json);
			logger.info(JsonUtils.toJson(respone, false));
			MerchantQueryResponse result = JsonUtils.fromJson(parse(respone), new TypeToken<MerchantQueryResponse>() {});
		} catch (Exception e) {
			logger.error("异常：", e);
		}
	}

	private Response process(String json) throws ValidationException {
		Response respone = JsonUtils.fromJson(json, new TypeToken<Response>() {
		});
		return respone;
	}

	public static void main(String[] args){
		MerchantAddRequest request = new MerchantAddRequest();
		request.setMerchantType("01"); //string 是 2 商户类型01-个人，02-企业
		request.setMerchantNo("2017070501"); //string 是 50 商户编号（商户在机构的唯一标识）
		request.setMerchantName("测试商户070501"); //string 是 100 商户名称
		request.setMerchantAbbName("测试商户070501"); //string 是 50 商户简称
		request.setMerchantAddress("测试商户070501"); //string 是 300 商户地址
		request.setProvinceCode("110000"); //string 是 16 省份编码 详见附件地区代码
		request.setCityCode("110000"); //string 是 16 城市代码
		request.setDistrictCode("110101"); //string 是 16 区县代码
		request.setContactName("联系人"); //string 是 50 联系人姓名
		request.setContactPhone("18888888888"); //string 是 20 联系人电话 （手机或座机）
		request.setContactEmail("test@email.com"); //string 否 50 联系人email
		request.setLegalName("测试人"); //string 是 50 法人姓名(个人经营填营业执照上的姓名)
		request.setLegalIdType("01"); //string 是 2 法人证件类型 01-身份证
		request.setLegalIdNo("511025198811143271"); //string 是 30 法人证件号码
		request.setMerchantCardType("01"); //string 否 2 商户证件类型 01:营业执照02:统一社会信用代码
		request.setMerchantCardNo("123456"); //string 否 40 商户证件号码
		request.setBeginTermTime("20170701"); //string 否 8 商户证件有效期开始日期（格式:yyyyMMdd）
		request.setEndTermTime("20190701"); //string 否 8 商户证件有效期结束日期（格式:yyyyMMdd）
		request.setSettleType("01"); //string 是 2 清算类型 00：直清，01：非直清
		request.setBgRetUrl("http://192.168.2.27:8400/"); //后台回调地址
		request.setBusinessScope("测试范围"); //经营范围
		
		List<SettleAccountInfo> settleAccountInfo = new ArrayList<SettleAccountInfo>(); //string 是  商户清算账户信息
		request.setSettleAccountInfo(settleAccountInfo);
		SettleAccountInfo settleAccountInfo1 = new SettleAccountInfo();
		settleAccountInfo1.setAccountName("测试名称");
		settleAccountInfo1.setAccountNo("6225887850632312");
		settleAccountInfo1.setBankAccountType("00");
		settleAccountInfo1.setBankNo("");
		settleAccountInfo1.setBankType("CMB");
		settleAccountInfo.add(settleAccountInfo1);
		List<Payment> payments = new ArrayList<Payment>(); //string 支付方式参数
		request.setPayments(payments);
		Payment payment1 = new Payment();
		payment1.setPaymentType("01");
		payment1.setCategory("155");
		payments.add(payment1);
		List<Fee> fees = new ArrayList<Fee>(); //string 费用参数
		request.setFees(fees);
		Fee fee1 = new Fee();
		fee1.setTimeType("01");
		fee1.setFeeType("00");
		fee1.setFeeParam("0.4");
		fees.add(fee1);
		
		new MerchantAddDemo().merchantAdd(request);
	}
}
