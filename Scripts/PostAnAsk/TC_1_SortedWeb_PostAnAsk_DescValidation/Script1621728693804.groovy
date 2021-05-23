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
	'Login'
	WebUI.openBrowser('')
	
	WebUI.maximizeWindow()
	
	WebUI.navigateToUrl('https://stagweb.gosorted.com/')
	
	WebUI.click(findTestObject('Object Repository/Login/LoginButton'))
	
	WebUI.click(findTestObject('Object Repository/Login/LoginUsingEmail'))
	
	WebUI.setText(findTestObject('Object Repository/Login/EmailTextField'), 'sachin@gosorted.com')
	
	WebUI.setEncryptedText(findTestObject('Object Repository/Login/PasswordTextField'), 'iUHyeRpZ8LLdpMUyOO0ujg==')
	
	WebUI.click(findTestObject('Object Repository/Login/ProceedButton'))
	
	'Test case being - TC_1_SortedWeb_PostAnAsk_DescValidation'
	WebUI.click(findTestObject('Object Repository/ToolBar/PostAnAskIcon'))
	
	WebUI.click(findTestObject('Object Repository/PostAnAsk/DecisionTypeDropdown'))
	
	WebUI.click(findTestObject('Object Repository/PostAnAsk/DecisionMenuItem'))
	
	WebUI.setText(findTestObject('Object Repository/PostAnAsk/DescriptionTextArea'), 'too short')
	
	WebUI.click(findTestObject('Object Repository/PostAnAsk/ProceedButton'))
	
	'Verify too short description error message'
	String tooShortErrorMessage = WebUI.getText(findTestObject('Object Repository/PostAnAsk/TooShortDescErrorMessage'))
	
	WebUI.verifyMatch(tooShortErrorMessage, 'Please provide a more descriptive ask', false)
	
	System.out.println(tooShortErrorMessage)
	
	WebUI.setText(findTestObject('Object Repository/PostAnAsk/DescriptionTextArea'), 'India (Hindi: Bhārat), officially the Republic of India (Hindi: Bhārat Gaṇarājya),[23] is a country in South Asia. It is the second-most populous country, the seventh-largest country by land area, and the most populous democracy in the world. Bounded by the Indian Ocean on the south, the Arabian Sea on the southwest, and the Bay of Bengal on the southeast, it shares land borders with Pakistan to the west;[f] China, Nepal, and Bhutan to the north; and Bangladesh and Myanmar to the east. In the Indian Ocean, India is in the vicinity of Sri Lanka and the Maldives; its Andaman and Nicobar Islands share a maritime border with Thailand, Myanmar and Indonesia.\n\nModern humans arrived on the Indian subcontinent from Africa no later than 55,000 years ago.[24] Their long occupation, initially in varying forms of isolation as hunter-gatherers, has made the region highly diverse, second only to Africa in human genetic diversity.[25] Settled life emerged on the subcontinent in the western margins of the Indus river basin 9,000 years ago, evolving gradually into the Indus Valley Civilisation of the third millennium BCE.[26] By 1200 BCE, an archaic form of Sanskrit, an Indo-European language, had diffused into India from the northwest,[27] unfolding as the language of the Rigveda, and recording the dawning of Hinduism in India.[28][disputed – discuss] The Dravidian languages of India were supplanted in the northern and western regions.[29] By 400 BCE, stratification and exclusion by caste had emerged within Hinduism,[30] and Buddhism and Jainism had arisen, proclaiming social orders unlinked to heredity.[31] Early political consolidations gave rise to the loose-knit Maurya and Gupta Empires based in the Ganges Basin.[32] Their collective era was suffused with wide-ranging creativity,[33] but also marked by the declining status of women,[34] and the incorporation of untouchability into an organised system of belief.[g][35] In South India, the Middle kingdoms exported Dravidian-languages scripts and religious cultures to the kingdoms of Southeast Asia.[36]')
	
	'Verify too long description error message'
	String tooLongErrorMessage = WebUI.getText(findTestObject('Object Repository/PostAnAsk/TooLongDescErrorMessage'))
	
	WebUI.verifyMatch(tooLongErrorMessage, 'You have exceeded the maximum allowed limit of 1024 characters for your Ask description.', false)
	
	System.out.println(tooLongErrorMessage)
} finally {
	WebUI.closeBrowser()
}