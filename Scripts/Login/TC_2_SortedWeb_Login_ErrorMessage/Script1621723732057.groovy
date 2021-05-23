import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
	WebUI.openBrowser('')
	
	WebUI.maximizeWindow()
	
	WebUI.navigateToUrl('https://stagweb.gosorted.com/')
	
	WebUI.click(findTestObject('Object Repository/Login/LoginButton'))
	
	WebUI.click(findTestObject('Object Repository/Login/LoginUsingEmail'))
	
	WebUI.setText(findTestObject('Object Repository/Login/EmailTextField'), 'invalidEmail')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Login/PasswordTextField'), '')
	
	'click somewhere in dialog'
	WebUI.click(findTestObject('Object Repository/Login/User_Name_Error_Message'))
	
	'Verify inline invalid email error message'
	String invalidEmailErrorMessage = WebUI.getText(findTestObject('Object Repository/Login/User_Name_Error_Message'))
	
	WebUI.verifyMatch(invalidEmailErrorMessage, 'Please enter a valid email before proceeding', false)
	
	System.out.println(invalidEmailErrorMessage)
	
	'Verify inline invalid password error message'
	String invalidPasswordErrorMessage = WebUI.getText(findTestObject('Object Repository/Login/User_Password_Error_Message'))
	
	WebUI.verifyMatch(invalidPasswordErrorMessage, 'Please enter your password before proceeding', false)
	
	System.out.println(invalidPasswordErrorMessage)
	
} finally {
	WebUI.closeBrowser()
}

