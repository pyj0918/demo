package demo.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.util.JsonUtil;
import demo.util.StringUtil;

public class RequestParam {
	private String systemCode;
	private String systemId;
	private String systemType;
	private String serviceId;
	
	private String seqId;
	private ServiceType requestType;
	private List<TXDataObject> dataItems=new ArrayList<>();
	private Map<String, Object> attributes=new HashMap<String, Object>();

	
	public String getSeqId() {
		return seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name) {
		return (T) attributes.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name,T defaultValue) {
		T temp=(T) attributes.get(name);
		 if(temp==null){
			 temp=defaultValue;
		 }
		 return temp;
	}
	
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void removeAttribute(String name){
		attributes.remove(name);
	}
	
	
	public void setAttribute(String name,Object value) {
		attributes.put(name, value);
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes.putAll(attributes);
	}



	public ServiceType getRequestType() {
		return requestType;
	}

	public void setRequestType(ServiceType requestType) {
		this.requestType = requestType;
	}
	
	public RequestParam() {
	}
	public RequestParam(String serviceId) {
		this.serviceId = serviceId;
	}

	public RequestParam(String serviceId, String systemId, String systemCode, String systemType, List<TXDataObject> dataItems) {
		this.systemCode = systemCode;
		this.systemId = systemId;
		this.systemType = systemType;
		this.serviceId = serviceId;
		this.dataItems = dataItems;
	}

	public boolean validate() {
		if (StringUtil.isEmpty(systemId) || StringUtil.isEmpty(systemType) || StringUtil.isEmpty(systemCode) || StringUtil.isEmpty(serviceId)) {
			return false;
		}
		return true;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
 

 
	public List<TXDataObject> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<TXDataObject> dataItems) {
		this.dataItems=dataItems;
	}

	public void addDataItem(TXDataObject item) {
		dataItems.add(item);
	}
	
	public void addDataItems(TXDataObject item) {
		dataItems.add(item);
	}

	public void addDataList(List<TXDataObject> items) {
		if(items!=null){
			dataItems.addAll(items);
		}
	}
	public void removeDataItem(TXDataObject item){
		dataItems.remove(item);
	}
	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	@Override
	public String toString() {
		return "RequestParam [serviceId=" + serviceId + "]";
	}

	public static void main(String[] args) {
		RequestParam pa=new RequestParam();
		pa.setSystemCode("dd");
		System.out.println(JsonUtil.toJson(pa));
		
		String json="{\"systemCode\":\"dd\",\"dffff\":\"3dd\"}";
		RequestParam te=	JsonUtil.toObject(json, RequestParam.class);
		System.out.println(te.getSystemCode());
	}
}
