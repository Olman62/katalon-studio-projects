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
import postsPackage.PostClass
import groovy.json.JsonSlurper as JsonSlurper

def jsonSlurper = new JsonSlurper()

'Create a new post'
def createdPostResponse = WS.sendRequest(findTestObject('Create New Post'))

WS.verifyResponseStatusCode(createdPostResponse, 201)

def createdPostObject = jsonSlurper.parseText(createdPostResponse.responseText)

assert 'The createdPostResponse is null' && createdPostObject!=null

def createdPost = createdPostObject as PostClass

postClassName=createdPost.getClass().getName()

assert 'the value postClassName is not type of postsPackage.PostClass' && postClassName=='postsPackage.PostClass'

assert ('The created post ID is not 101') && createdPost.id==101
