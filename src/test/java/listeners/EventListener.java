package listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utils.JiraProvider.createJiraIssue;

public class EventListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        String issueDescription = "Failure Reason from Automation Testing\n\n"
                + result.getThrowable().getMessage()
                + "\n";
        issueDescription = issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
        String issueSummary = result.getMethod().getConstructorOrMethod().getName() +
                " Failed in Automation Testing";
        createJiraIssue(issueSummary, issueDescription);
    }
}
