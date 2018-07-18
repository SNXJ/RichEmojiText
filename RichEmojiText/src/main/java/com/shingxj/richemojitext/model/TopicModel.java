package com.shingxj.richemojitext.model;

import java.io.Serializable;

/**
 * 话题model
 */

public class TopicModel implements Serializable {
    /**
     * 话题名字内部不能有#和空格
     */
    private String topicName;
    private String topicId;

   

    public TopicModel() {

    }

    public TopicModel(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return this.topicName;
    }
}
