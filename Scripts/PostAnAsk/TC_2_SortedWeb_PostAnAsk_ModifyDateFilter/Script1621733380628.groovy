import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
	WebUI.openBrowser('')
	
	WebUI.maximizeWindow()
	
	WebUI.navigateToUrl('https://stagweb.gosorted.com/')
	
	WebUI.click(findTestObject('Object Repository/Login/LoginButton'))
	
	WebUI.click(findTestObject('Object Repository/Login/LoginUsingEmail'))
	
	WebUI.setText(findTestObject('Object Repository/Login/EmailTextField'), 'sachin@gosorted.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Login/PasswordTextField'), 'iUHyeRpZ8LLdpMUyOO0ujg==')
	
	WebUI.click(findTestObject('Object Repository/Login/ProceedButton'))
	
	'Test case being - TC_2_SortedWeb_PostAnAsk_ModifyDateFilter'
	WebUI.click(findTestObject('Object Repository/ToolBar/PostAnAskIcon'))
	
	
	'Verify urgent ask label'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/UrgentCheckBox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ConfirmButton'))
	String urgentAskLabel = WebUI.getText(findTestObject('PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(urgentAskLabel, 'Urgent', false)
	System.out.println(urgentAskLabel)
	
	'Verify no due date ask label'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/NoDueDateCheckbox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ConfirmButton'))
	String noDueDateAskLabel = WebUI.getText(findTestObject('Object Repository/PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(noDueDateAskLabel, 'No due date set', false)
	System.out.println(noDueDateAskLabel)
	
	'Verify custom due date (2 days) ask label'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/CustomDueDateDateCheckbox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ConfirmButton'))
	String twoDaysAskLabel = WebUI.getText(findTestObject('PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(twoDaysAskLabel, '2 DAYS', false)
	System.out.println(twoDaysAskLabel)
	
	'Verify custom due date (1 week) ask label'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/CustomDueDateDateCheckbox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/DateDropDown'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/WeeksDropDownMenu'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ConfirmButton'))
	String oneWeekAskLabel = WebUI.getText(findTestObject('Object Repository/PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(oneWeekAskLabel, '7 DAYS', false)
	System.out.println(oneWeekAskLabel)
	
	'Verify custom due date (1 month) ask label'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/CustomDueDateDateCheckbox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/DateDropDown'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/MonthDropDownMenu'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ConfirmButton'))
	String oneMonthAskLabel = WebUI.getText(findTestObject('Object Repository/PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(oneMonthAskLabel, '30 DAYS', false)
	System.out.println(oneMonthAskLabel)
	
	'Verify due date dialog issue'
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ModifyButton'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/UrgentCheckBox'))
	WebUI.click(findTestObject('Object Repository/PostAnAsk/DialogCloseButton'))
	String oneMonthAskUnmodifiedLabel = WebUI.getText(findTestObject('Object Repository/PostAnAsk/DueDateLabel'))
	WebUI.verifyMatch(oneMonthAskUnmodifiedLabel, '30 DAYS', false)
	System.out.println(oneMonthAskUnmodifiedLabel)
} finally { 
	WebUI.closeBrowser()
}