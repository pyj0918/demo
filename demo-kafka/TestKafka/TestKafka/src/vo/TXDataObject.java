package vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TXDataObject {
	private String objectId;
	private List<TXDataObject> subItems = new ArrayList<>();
	private Map<String, Object> attributes = new HashMap<String, Object>();

	private DataOperationType operateType = DataOperationType.READ;

	public TXDataObject() {
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public List<TXDataObject> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<TXDataObject> subItems) {
		this.subItems = subItems;
	}

	public void addSubItem(TXDataObject item) {
		this.subItems.add(item);
	}

	public void addSubItems(List<TXDataObject> subItems) {
		if (subItems != null)
			this.subItems.addAll(subItems);
	}

	public void removeSubItem(TXDataObject item) {
		this.subItems.remove(item);
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		if (attributes != null)
			this.attributes.putAll(attributes);
	}

	public DataOperationType getOperateType() {
		return operateType;
	}

	public void setOperateType(DataOperationType operateType) {
		this.operateType = operateType;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name) {
		return (T) attributes.get(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAttribute(String name, T defaultValue) {
		T temp = (T) attributes.get(name);
		if (temp == null) {
			temp = defaultValue;
		}
		return temp;
	}

	public void removeAttribute(String name) {
		attributes.remove(name);
	}

	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

}
