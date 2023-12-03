/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Generator.generator;

/**
 *
 * @author user
 */
public class Keyword {
    
    private String id;
    private String keyword;
    private String response;
    
    public Keyword(String id, String keyword, String response) {
        this.id = id;
        this.keyword = keyword;
        this.response = response;
    }
    
    public Keyword(String keyword, String response) {
        generator Generator = new generator();
        this.id = Generator.getId();
        this.keyword = keyword;
        this.response = response;
    }
    
    public void print() {
        System.out.println("id       : " + id);
        System.out.println("keyword  : " + keyword);
        System.out.println("response : " + response);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
}
