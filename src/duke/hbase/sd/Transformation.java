package duke.hbase.sd;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class Transformation {

	private Query q;
	private String	type; 
	private Method transformationRule;
	private ArrayList<Object> arguments;
	
	public Query getQ() {
		return q;
	}
	public void setQ(Query q) {
		this.q = q;
	}
	public Method getTransformationRule() {
		return transformationRule;
	}
	public void setTransformationRule(Method transformationRule) {
		this.transformationRule = transformationRule;
	}
	public ArrayList<Object> getArguments() {
		return arguments;
	}
	public void setArguments(ArrayList<Object> arguments) {
		this.arguments = arguments;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Rule: " + getTransformationRule().getName() + "\n");
		sb.append("arguments: \n");
		Iterator<Object> a_itr = getArguments().iterator();
		while(a_itr.hasNext()) {
		  Object obj = a_itr.next();
		  sb.append(obj.toString());
		}
		return sb.toString();
	}
	public String toShortString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Rule: " + getTransformationRule().getName() + "\n");
		sb.append("arguments: \n");
		Iterator<Object> a_itr = getArguments().iterator();
		while(a_itr.hasNext()) {
		  Object obj = a_itr.next();
		  if(Table.class.isInstance(obj)) {
			  sb.append(((Table)obj).getName() + ", ");
		  }
		}
		return sb.toString();
	}
}
