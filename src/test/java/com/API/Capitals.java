package com.API;

import java.util.ArrayList;
import java.util.List;


public class Capitals {

    public static class currenciesClass{
        public String code;
        public String name;
        public String symbol;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public static class languagesClass {
        public String iso639_1;
        public String iso639_2;
        public String name;
        public String nativeName;

        public String getIso639_1() {
            return iso639_1;
        }

        public String getIso639_2() {
            return iso639_2;
        }

        public String getName() {
            return name;
        }

        public String getNativeName() {
            return nativeName;
        }
    }

    public static class translationsClass{
        public String de;
        public String es;
        public String fr;
        public String ja;
        public String it;
        public String br;
        public String pt;
        public String nl;
        public String hr;
        public String fa;

        public String getDe() {
            return de;
        }

        public String getEs() {
            return es;
        }

        public String getFr() {
            return fr;
        }

        public String getJa() {
            return ja;
        }

        public String getIt() {
            return it;
        }

        public String getBr() {
            return br;
        }

        public String getPt() {
            return pt;
        }

        public String getNl() {
            return nl;
        }

        public String getHr() {
            return hr;
        }

        public String getFa() {
            return fa;
        }
    }





    String name;
    List<String> topLevelDomain = new ArrayList<>();
    String alpha2Code;
    String alpha3Code;
    List<String> callingCodes;
    String capital;
    List<String> altSpellings;
    String region;
    String subregion;
    Integer population;
    List<String> latlng;
    String demonym;
    String area;
    String gini;
    List<String> timezones;
    List<String> borders;
    String nativeName;
    String numericCode;
    List<currenciesClass> currencies = new ArrayList<>();
    List<languagesClass> languages = new ArrayList<>();
    translationsClass translations;
    String flag;
    List<String> regionalBlocs;
    String cioc;

    public String getName() {
        return name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public List<String> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public String getArea() {
        return area;
    }

    public String getGini() {
        return gini;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public List<currenciesClass> getCurrencies() {
        return currencies;
    }

    public List<languagesClass> getLanguages() {
        return languages;
    }

    public translationsClass getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public List<String> getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public List<String> getTimezones() {
        return timezones;
    }
}
