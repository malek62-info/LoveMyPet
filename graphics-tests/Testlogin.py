import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

driver_path = 'msedgedriver.exe'
edge_options = webdriver.EdgeOptions()
edge_options.use_chromium = True

driver = webdriver.Edge(options=edge_options)
driver.get('http://localhost:8086/login')
time.sleep(5)

# Remplir le champ Email
email_field = driver.find_element("id", 'email')
email_field.send_keys('faiz@gmail.com')

time.sleep(5)
password_field = driver.find_element("id", 'password')
password_field.send_keys('faiz')

time.sleep(5)
login_button = driver.find_element("name", 'submit')
time.sleep(5)
login_button.click()

try:
    WebDriverWait(driver, 10).until(
        EC.url_to_be("http://localhost:8086/profile")
    )
    print("Connexion réussie ! Vous êtes sur la page de profil.")
   
except TimeoutException:
    print("La page de profil n'a pas été chargée dans les délais.")

time.sleep(5)
