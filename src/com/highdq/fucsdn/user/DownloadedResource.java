package com.highdq.fucsdn.user;

/**
 * 已经下载的资源
 * @author Yutsing Lee
 *
 */
public class DownloadedResource {
    /**
     * 评论的地址
     */
    private String commentUrl;
    
    /**
     * 资源的地址
     */
    private String resourceUrl;
    
    /**
     * 资源是否已经评论
     */
    private boolean comment;
    
    /**
     * @param commentUrl 评论地址
     * @param resourceUrl 资源地址
     * @param comment 是否已经评论
     */
    public DownloadedResource(String commentUrl, String resourceUrl, boolean comment) {
    	this.commentUrl = commentUrl;
    	this.resourceUrl = resourceUrl;
    	this.comment = comment;
    }

	public String getCommentUrl() {
		return commentUrl;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public boolean isComment() {
		return comment;
	}
}
