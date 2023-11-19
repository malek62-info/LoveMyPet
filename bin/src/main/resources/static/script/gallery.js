document.addEventListener('DOMContentLoaded', function () {
    const galleryContent = document.getElementById('galleryContent');
    const animals = [
        { image: '/images/person1.jpg' },
        { image: '/images/person2.jpg' },
        { image: '/images/person3.jpg' },
        { image: '/images/person4.jpg' },
        { image: '/images/person5.jpg' }
    ];

    // Générer le contenu de la galerie
    animals.forEach(animal => {
        const animalDiv = document.createElement('div');
        animalDiv.classList.add('animal');

        const img = document.createElement('img');
        img.src = animal.image;
        img.alt = animal.name;

        

        animalDiv.appendChild(img);
        galleryContent.appendChild(animalDiv);
    });

    // Défilement automatique
    let currentIndex = 0;

    function showanimal(index) {
        const newPosition = -index * 100 + '%';
        galleryContent.style.transform = 'translateX(' + newPosition + ')';
    }

    function nextanimal() {
        currentIndex = (currentIndex + 1) % animals.length;
        showanimal(currentIndex);
    }

    // Déclenche le défilement automatique
    setInterval(nextanimal, 3000);
});
