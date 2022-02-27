export class NotFoundError extends Error {

}
export class UnauthorizedError extends Error {

}

export async function api(url, method = 'GET', body = {}, headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
}) {

    const r = await fetch(url, {
        method,
        headers,
        body: JSON.stringify(body)
    });

    if (r.status >= 0 && r.status < 400) {
        return await r.json();
    }
    if (r.status === 400) {
        throw new NotFoundError();
    }

    if (r.status === 401) {
        throw new UnauthorizedError();
    }
}

function isEmptyObj(obj) {
 return obj && Object.keys(obj).length === 0 && Object.getPrototypeOf(obj) === Object.prototype;
}