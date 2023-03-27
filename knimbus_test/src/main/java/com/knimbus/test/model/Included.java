package com.knimbus.test.model;
public class Included{
    public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public Relationships getRelationships() {
		return relationships;
	}
	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Attributes attributes;
    public String id;
    public Links links;
    public Relationships relationships;
    public String type;
}

