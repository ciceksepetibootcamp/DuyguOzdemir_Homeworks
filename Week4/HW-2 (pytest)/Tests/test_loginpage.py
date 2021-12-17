import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By


class Test_LogIn():

    @pytest.fixture()
    def test_setup(self):
        driver = webdriver.Chrome()
        driver.implicitly_wait(8)
        driver.get("https://www.hepsiburada.com/")
        driver.maximize_window()

        yield
        driver.close()
        driver.quit()

    def test_success_login(self, test_setup):
        assert self.driver.find_element(By.XPATH, "//*[@id='myAccount']/span/a/span[2]").get_attribute(
            'textContent') == "test user"

    def test_failed_login(self, test_setup):
        assert self.driver.find_element(By.XPATH, "//div[@class='hb-fzpaiS zPvsX ss2dihtiydp']").get_attribute(
            'textContent') == "Girdiğiniz şifre eksik veya hatalı."
