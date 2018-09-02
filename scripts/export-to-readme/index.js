const Promise = require('bluebird');
const clinics = require('./postman_collection');
const _ = require('lodash/fp/lang');
const writeFile = Promise.promisify(require('fs').writeFile);

(async() => {
    let output = [];
    let items = clinics.item;
    let baseURL = 'http://clinicat.tk';

    items.forEach((endpoint) => {
        let title = endpoint.name;

        output.push('* ' + title + ':');

        endpoint.item.forEach((item) => {
            let body = item.request.body;
            let method = item.request.method;
            let url = item.request.url.raw.replace('{{url}}', baseURL);
            let endpoint = `${method}: ${url}`;

            output.push(endpoint);

            if(!_.isEmpty(body)) {
                let bodyRaw = body.raw;
                bodyRaw = bodyRaw.replace("\\", '').replace(/\s\s+/g, ' ');
                let template = `Body: ${bodyRaw}`;
                output.push(template);
                output.push('');
            }
        });
        output.push('');
    });
    let outputString = output.join('\n');

    try {
        await writeFile('README.txt', outputString);
    } catch (e) {
        console.log(e.message);
    }

    process.exit();
})();

