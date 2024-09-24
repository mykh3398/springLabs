document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');
    const sortDate = document.getElementById('sortDate');
    const sortVotes = document.getElementById('sortVotes');
    const petitionList = document.getElementById('petitionList');

    // Функція пошуку
    searchInput.addEventListener('input', function () {
        const query = searchInput.value.toLowerCase();
        const petitions = petitionList.getElementsByClassName('petition-item');

        Array.from(petitions).forEach(function (petition) {
            const title = petition.querySelector('a').innerText.toLowerCase();
            if (title.includes(query)) {
                petition.style.display = '';
            } else {
                petition.style.display = 'none';
            }
        });
    });

    // Функція сортування за датою
    sortDate.addEventListener('click', function (e) {
        e.preventDefault();
        sortPetitions('date');
    });

    // Функція сортування за голосами
    sortVotes.addEventListener('click', function (e) {
        e.preventDefault();
        sortPetitions('votes');
    });

    // Функція сортування петицій
    function sortPetitions(criteria) {
        const petitions = Array.from(petitionList.getElementsByClassName('petition-item'));
        petitions.sort(function (a, b) {
            let aValue, bValue;

            if (criteria === 'date') {
                aValue = new Date(a.querySelector('a').getAttribute('th:text')).getTime();
                bValue = new Date(b.querySelector('a').getAttribute('th:text')).getTime();
            } else if (criteria === 'votes') {
                aValue = parseInt(a.querySelector('.fw-bold').innerText);
                bValue = parseInt(b.querySelector('.fw-bold').innerText);
            }

            return criteria === 'date' ? bValue - aValue : bValue - aValue;
        });

        petitions.forEach(function (petition) {
            petitionList.appendChild(petition);
        });
    }
});
