package Sorting;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.*;

class ResponseData {
    private int page;
    private int total_page;
    private int total;
    private List<Content> content;

    public int getPage() {
        return page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(final int total_page) {
        this.total_page = total_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(final List<Content> content) {
        this.content = content;
    }
}

class Content {
    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }
}

public class AuthorArticles {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String author = bufferedReader.readLine();

        List<String> result = getArticleTitles(author);

        System.out.println("result::"+result.toString());

    }

    private static List<String> getArticleTitles(final String author) throws IOException {
        List<String> result = new ArrayList<>();

        int pageNumber = 1;
        int totalPages = 1;

        do {

            String url = "https://restmock.techgig.com/news?author=" + author + "&page=" + pageNumber + "";
            String data = getJSON(url);
            ResponseData responseData = new Gson().fromJson(data, ResponseData.class);

            pageNumber = responseData.getPage()+1;
            totalPages = responseData.getTotal_page();

            for (Content content : responseData.getContent()) {
                if(null != content.getTitle() && content.getTitle().length() !=0) {
                    result.add(content.getTitle());
                } else if(null != content.getLink()  && content.getLink().length() !=0 ) {
                    result.add(content.getLink());
                }
            }
        } while (pageNumber<=totalPages);

        result = result.stream().sorted().collect(Collectors.toList());
        return result;
    }

    public static String getJSON(String url) throws IOException {
        HttpURLConnection c = null;
        URL u = new URL(url);
        c = (HttpURLConnection) u.openConnection();
        c.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }

}
