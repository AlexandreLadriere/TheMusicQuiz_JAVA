/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:34:54 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:34:54 
 */
package com.themusicquiz.composants;

import java.util.Objects;
import java.io.IOException;

public class Item {
    protected String itemTitle;
    protected String itemAuthor;
    protected String itemCoverPath;
    protected String itemSummaryPath;
    protected String itemWikiLink;
    protected String itemDate;
    protected String itemDescription;

    public Item() {
        itemTitle = "";
        itemAuthor = "";
        itemCoverPath = "";
        itemSummaryPath = "";
        itemWikiLink = "";
        itemDate = "";
        this.updateItemDescription();
    }

    public Item(String pItemAuthor, String pItemTitle, String pItemDate, String pItemWikiLink, String pItemCoverPath, String pItemSummaryPath) {
        itemTitle = pItemTitle;
        itemAuthor = pItemAuthor;
        itemCoverPath = pItemCoverPath;
        itemSummaryPath = pItemSummaryPath;
        itemWikiLink = pItemWikiLink;
        itemDate = pItemDate;
        this.updateItemDescription();
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemAuthor() {
        return itemAuthor;
    }

    public String getItemCoverPath() {
        return itemCoverPath;
    }

    public String getItemSummaryPath() {
        return itemSummaryPath;
    }

    public String getItemWikiLink() {
        return itemWikiLink;
    }

    public String getItemDate() {
        return itemDate;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemSummary() throws IOException{
        String itemSummary = "";
        FileHandler fileReader = new FileHandler();
        try {
            itemSummary = fileReader.ReadFile_Files_ReadAllBytes(this.itemSummaryPath);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return itemSummary;
    }

    public void setItemTitle(String pItemTitle) {
        this.itemTitle = pItemTitle;
        this.updateItemDescription();
    }

    public void setItemAuthor(String pItemAuthor) {
        this.itemAuthor = pItemAuthor;
        this.updateItemDescription();
    }

    public void setItemCoverPath(String pItemCoverPath) {
        this.itemCoverPath = pItemCoverPath;
    }

    public void setItemSummaryPath(String pItemSummaryPath) {
        this.itemSummaryPath = pItemSummaryPath;
    }

    public void setItemWikiLink(String pItemWikiLink) {
        this.itemWikiLink = pItemWikiLink;
    }

    public void setItemDate(String pItemDate) {
        this.itemDate = pItemDate;
        this.updateItemDescription();
    }

    public String toString() {
        return "\tTitle: "+this.itemTitle+"\n\tAuthor: "+this.itemAuthor+"\n\tDate: "+this.itemDate+"\n\tWikiLink: "+this.itemWikiLink+"\n\tCoverPath: "+this.itemCoverPath+"\n\tSummaryPath: "+this.itemSummaryPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        return Objects.equals(other.getItemTitle(), this.getItemTitle()) && Objects.equals(other.getItemAuthor(), this.getItemAuthor()) && Objects.equals(other.getItemDate(), this.getItemDate()) && Objects.equals(other.getItemCoverPath(), this.getItemCoverPath()) && Objects.equals(other.getItemSummaryPath(), this.getItemSummaryPath()) && Objects.equals(other.getItemWikiLink(), this.getItemWikiLink());
    }

    private void updateItemDescription() {
        itemDescription = "\""+this.itemTitle+"\""+" was released by "+this.itemAuthor+" in "+this.itemDate;
    }
}
