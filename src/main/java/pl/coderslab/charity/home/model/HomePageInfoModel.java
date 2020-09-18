package pl.coderslab.charity.home.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.institution.entity.Institution;

import java.lang.reflect.Array;

@Getter
@Setter
public class HomePageInfoModel {
    public HomePageInfoModel() {
    }

    public HomePageInfoModel(int bags, int donations, Institution[] institutions) {
        this.bags = bags;
        this.donations = donations;
        this.institutions = institutions;
    }

    private int bags;
    private int donations;
    private Institution[] institutions;
}
