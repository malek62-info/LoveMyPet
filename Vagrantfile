# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|


  # Configuration de la box Vagrant avec Docker
    config.vm.box = "generic/ubuntu1804"
    config.vm.provider "virtualbox" do |vb|
      vb.memory = "2048"
    end

  # Configuration des images Docker
  config.vm.provision "docker" do |docker|
    docker.pull_images = true
    docker.build_image "C:\Users\malek\Desktop\LoveMyPet\lovemypet-app", args: "-t lovemypet-app"
    docker.build_image "C:\Users\malek\Desktop\LoveMyPet\database", args: "-t lmp_db"
  end

  # Configuration des conteneurs Docker
  config.vm.define "database" do |db|
    db.vm.provider "docker" do |d|
      d.image = "lmp_db"
      d.name = "lmp_db"
      d.ports = ["3306:3306"]
    end
  end

  config.vm.define "lovemypet-app" do |app|
    app.vm.provider "docker" do |d|
      d.image = "lovemypet-app"
      d.name = "lovemypet-app"
      d.ports = ["8080:8080"]
      d.env = {
        "SPRING_DATASOURCE_URL" => "jdbc:mysql://database:3306/lmv",
        # Ajoutez d'autres variables d'environnement nécessaires à votre application Spring Boot
      }
      d.depends_on = ["database"]
    end
  end

end
