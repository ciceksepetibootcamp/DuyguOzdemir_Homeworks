import time

from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By


class LogIn():
    def __init__(self, driver):
        self.driver = driver
        self.input_data_on_search_box = driver.find_element_by_class_name("desktopOldAutosuggestTheme-input")

    def success_login(self):

         xpath = "//span[.='Giriş Yap']"

        def hover(self, xpath):
            self.element_to_hover_over = self.driver.find_element_by_xpath(xpath)
            self.hover = ActionChains(self.driver).move_to_element(self.element_to_hover_over)
            self.hover.perform()

        self.driver.find_element(By.CSS_SELECTOR, ".sf-OldMyAccount-PhY-T:nth-child(1)").click()
        self.driver.find_element(By.ID, "login").click()
        self.driver.find_element(By.ID, "txtUserName").send_keys("testuserbootcamp@gmail.com")
        self.driver.find_element(By.ID, "txtUserName").click()
        self.driver.find_element(By.ID, "btnLogin").click()
        self.driver.find_element(By.ID, "txtPassword").click()
        self.driver.find_element(By.ID, "txtPassword").send_keys("Cs_123bcamp_123")
        self.driver.find_element(By.ID, "btnEmailSelect").click()


    def failed_login(self):
        self.driver.find_element(By.CSS_SELECTOR, ".sf-OldMyAccount-PhY-T:nth-child(1)").click()
        self.driver.find_element(By.ID, "login").click()
        self.driver.find_element(By.ID, "txtUserName").send_keys("testuserbootcamp@gmail.com")
        self.driver.find_element(By.ID, "txtUserName").click()
        self.driver.find_element(By.ID, "btnLogin").click()
        self.driver.find_element(By.ID, "txtPassword").click()
        self.driver.find_element(By.ID, "txtPassword").send_keys("Cs_failed_123")
        self.driver.find_element(By.ID, "btnEmailSelect").click()

