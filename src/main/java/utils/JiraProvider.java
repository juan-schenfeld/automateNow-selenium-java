package utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;

public class JiraProvider {

    public static void createJiraIssue(String summary, String description){
        String password = System.getenv("JIRA_PASSWORD");
        String username = System.getenv("JIRA_USERNAME");
        String jiraUrl = "https://jschenfeld.atlassian.net/";
       if (username == null){
           System.out.println("its running in local so skipping the issue create");
       } else {
           try {
               BasicCredentials creds = new BasicCredentials(username,password);

               JiraClient jira = new JiraClient(jiraUrl, creds);

               Issue newIssue = jira.createIssue("JUS", "Bug")
                       .field(Field.SUMMARY, summary)
                       .field(Field.DESCRIPTION, description)
                       .execute();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

    }
}