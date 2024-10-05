package com.example.ufmsports;

import java.util.ArrayList;
import java.util.List;

public class model {
    // Example usage with ObjectMapper:
    // ObjectMapper om = new ObjectMapper();
    // Root root = om.readValue(myJsonString, Root.class);

    public static class A {
        public String name;
        public String code;
        public String logo_url;
        public String logo_bg_color;

        public A(String name, String code, String logo_url, String logo_bg_color) {
            this.name = name;
            this.code = code;
            this.logo_url = logo_url;
            this.logo_bg_color = logo_bg_color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getLogo_bg_color() {
            return logo_bg_color;
        }

        public void setLogo_bg_color(String logo_bg_color) {
            this.logo_bg_color = logo_bg_color;
        }
        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class B {
        public String name;
        public String code;
        public String logo_url;
        public String logo_bg_color;

        public B(String name, String code, String logo_url, String logo_bg_color) {
            this.name = name;
            this.code = code;
            this.logo_url = logo_url;
            this.logo_bg_color = logo_bg_color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getLogo_bg_color() {
            return logo_bg_color;
        }

        public void setLogo_bg_color(String logo_bg_color) {
            this.logo_bg_color = logo_bg_color;
        }
        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class Teams {
        public A a;
        public B b;

        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class MatchOffer {
        public String offer_icon_url;
        public String title;
        public String subtext;

        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class Metadata {
        public boolean is_lineup_out;
        public boolean is_match_initialized;

        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class MatchList {
        public String id;
        public String name;
        public String match_format;
        public String tournament_name;
        public String status;
        public long starts_at;  // Timestamp, better stored as long
        public Teams teams;
        public List<MatchOffer> match_offers = new ArrayList<>();
        public Metadata metadata;

        public MatchList(String id, String name, String match_format, String tournament_name, String status, long starts_at, Teams teams, List<MatchOffer> match_offers, Metadata metadata) {
            this.id = id;
            this.name = name;
            this.match_format = match_format;
            this.tournament_name = tournament_name;
            this.status = status;
            this.starts_at = starts_at;
            this.teams = teams;
            this.match_offers = match_offers;
            this.metadata = metadata;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMatch_format() {
            return match_format;
        }

        public void setMatch_format(String match_format) {
            this.match_format = match_format;
        }

        public String getTournament_name() {
            return tournament_name;
        }

        public void setTournament_name(String tournament_name) {
            this.tournament_name = tournament_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public long getStarts_at() {
            return starts_at;
        }

        public void setStarts_at(long starts_at) {
            this.starts_at = starts_at;
        }

        public Teams getTeams() {
            return teams;
        }

        public void setTeams(Teams teams) {
            this.teams = teams;
        }

        public List<MatchOffer> getMatch_offers() {
            return match_offers;
        }

        public void setMatch_offers(List<MatchOffer> match_offers) {
            this.match_offers = match_offers;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }
        // Getters and Setters (Optional, but recommended for encapsulation)
    }

    public static class Root {
        public List<MatchList> match_list = new ArrayList<>();
        public Object previous_page;  // Consider using Integer if you expect an integer
        public int next_page;

        // Getters and Setters (Optional, but recommended for encapsulation)
    }
}
