Vagrant.configure("2") do |config|
  # Utiliser une boîte Vagrant avec Docker préinstallé
  config.vm.box = "ubuntu/bionic64"
 
  # Installer Docker
  config.vm.provision "docker"
 
  # Partager le répertoire du projet avec la VM
  config.vm.synced_folder ".", "/vagrant", type: "virtualbox"
 
  # Installer Docker Compose avec les dépendances nécessaires
  config.vm.provision "shell", inline: <<-SHELL
    sudo apt-get update
    sudo apt-get install -y python3-pip python3-dev libffi-dev libssl-dev
    sudo pip3 install --upgrade pip setuptools-rust
    sudo pip3 install docker-compose
  SHELL
 
  # Construire les images Docker locales dans la VM Vagrant
  config.vm.provision "shell", inline: <<-SHELL
    echo "Construction des images Docker..."
    cd /vagrant
    docker build -t lovemypet-app .
    cd /vagrant/database
    docker build -t lmp_db .
  SHELL
 
  # Démarrer Docker Compose
  config.vm.provision "shell", inline: <<-SHELL
    cd /vagrant
    docker-compose up -d
  SHELL
end