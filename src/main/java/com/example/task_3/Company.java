package com.example.task_3;

import lombok.Getter;

@Getter
public class Company {
    private String name;
    private String description;
    private String logo;

    public void fillWithDataFromDomain(String domain) throws Exception{
        this.description = OpenAiReader.getDescription(domain);
        this.name = AbstractReader.getName(domain);
        this.logo = BrandFetch.getLogo(domain);
    }
}
