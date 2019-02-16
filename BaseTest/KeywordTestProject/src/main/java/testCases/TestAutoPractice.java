package testCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.KeywordUtil;
import util.TestCaseMapper;
@Listeners(listeners.TestListener.class)
public class TestAutoPractice extends KeywordUtil {

	@Test(dataProvider = "noOfTests")
	public void Test2(int rowNum) {

		System.out.println("Executing  test for " + testcaseMap.get(rowNum));
		int testStepStarts = rowNum;
		while (!(excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword).isEmpty())) {
			performAction(testStepStarts, excelutil.getCellData(testStepStarts, TestCaseMapper.Keyword));
			testStepStarts++;
		}
	}
}
