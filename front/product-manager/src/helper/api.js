import {isAuthenticate} from "./auth";

export class NotFoundError extends Error {

}
export class UnauthorizedError extends Error {

}

export class BadRequestError extends Error {

}

let header = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
}
if (isAuthenticate()) {
    header = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + window.localStorage.getItem('auth-tok')
    }
}
export async function api(url, method = 'GET', body = {}, headers = header) {
    let init = {
        method,
        headers,
        body: JSON.stringify(body)
    }
    if (method === 'GET') {
        init = {
            method,
            headers,
        }
    }
    const r = await fetch(url, init);

    if (r.status >= 0 && r.status < 400) {
        return await r.json();
    }
    if (r.status === 404) {
        throw new NotFoundError();
    }

    if (r.status === 401) {
        throw new UnauthorizedError();
    }
    if (r.status === 400) {
        throw new BadRequestError();
    }
}

function isEmptyObj(obj) {
 return obj && Object.keys(obj).length === 0 && Object.getPrototypeOf(obj) === Object.prototype;
}