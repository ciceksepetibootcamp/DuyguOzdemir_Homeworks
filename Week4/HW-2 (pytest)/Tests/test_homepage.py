from lib2to3.pgen2 import driver

import pytest
from selenium import webdriver
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.common.by import By
from Pages.homepage import HomePage


class Test_HomePage():

    @pytest.fixture()
    def test_setup(self):
        self.driver: WebDriver = webdriver.Chrome()
        driver.implicitly_wait(8)
        driver.get("https://www.hepsiburada.com/")
        driver.maximize_window()

        yield
        driver.close()
        driver.quit()

    def test_set_location(self, test_setup):
        cityLocation = "İzmir"
        home_page = HomePage(driver)
        home_page.set_city(cityLocation)
        assert self.driver.find_element(By.XPATH, f"//div[text()={cityLocation}']").get_attribute('textContent') == cityLocation

    def test_like_comments(self, test_setup):
        selectProduct = "Iphone"
        home_page = HomePage(driver)
        home_page.search_keyword(selectProduct)
