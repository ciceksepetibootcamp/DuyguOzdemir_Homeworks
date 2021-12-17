import time


class HomePage():
    def __init__(self, driver):
        self.driver = driver
        self.input_data_on_search_box = driver.find_element_by_class_name("desktopOldAutosuggestTheme-input")

    def set_city(self, lookforcity):

        # ----------------Click the Konum field-----------------
        locate_selection = self.driver.find_element_by_xpath("//div[text()='Konum']")
        locate_selection.click()

        # ----------------Click for the openning dropdown -----------------
        select_location = self.driver.find_element_by_xpath("//input[@class='shipping-Select-fake_input']")
        select_location.click()

        # ----------------Click on the search for dropdown -----------------
        click_location_dropdown = self.driver.find_element_by_xpath(
            "//div[@class='shipping-Select-input_wrapper shipping-ShippingLocationFormContent-city']/div[1]/div[3]")
        click_location_dropdown.click()

        for x in range(99):
            try:
                self.driver.find_element_by_css_selector(f"#react-select-{x}-option-0")
                city_id = x
            except:
                pass

        for x in range(0, 81):

            city = self.driver.find_element_by_css_selector(f"#react-select-{city_id}-option-{x}")
            citytext = city.get_attribute("textContent")
            if citytext == lookforcity:
                city.click()
                break

    def search_keyword(self, productName):
        self.driver.get("https://www.hepsiburada.com/")

        # ----------------Click the search button-----------------
        self.input_data_on_search_box.send_keys(productName)
        self.input_data_on_search_box.click()

        click_search_button = self.driver.find_element_by_css_selector(".SearchBoxOld-buttonContainer")
        click_search_button.click()

        # ----------------Select preffered product on page-----------------
        productUrl = self.driver.find_elements_by_css_selector("#i0 > div > a")[0].get_property("href")
        self.driver.get(productUrl)

        # -----------------Click the reviews tab-------------------
        q = self.driver.find_elements_by_xpath(
            "/html/body/div[2]/main/div[3]/section[3]/div/div/table/tbody/tr/td[3]/a")
        q[0].click()
        # -----------------Click the thumb icon on comments-------------------
        click_on_thumb = self.driver.find_element_by_css_selector(
            ".//*[@id='hermes-voltran-comments']/div[4]/div[3]/div/div{x}/div[2]/div[4]/div[1]/div/div[1]/div[1]/svg/g/g/g/g/g/g/path")
        click_on_thumb.click()
