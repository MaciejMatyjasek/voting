export class ObjectExtractor {
  static prepareObject(obj: Object, props: Array<ExtractModel | string>): Object {
    const result = {};

    props
      .filter(prop => this.hasProperty(obj, prop))
      .forEach(prop => {
        if (prop instanceof ExtractModel) {
          if (prop.source.includes('.')) {
            // @ts-ignore
            result[prop.target] = this.extractValue(obj, prop.source);
          } else {
            // @ts-ignore
            result[prop.target] = obj[prop.source];
          }
        } else {
          // @ts-ignore
          result[prop] = obj[prop];
        }
      });

    return result;
  }

  private static hasProperty(obj: Object, prop: ExtractModel | string): Boolean {
    if (prop instanceof ExtractModel) {
      if (prop.source.includes('.')) {
        return this.extractValue(obj, prop.source) !== null;
      }
      return obj.hasOwnProperty(prop.source);
    } else if (obj) {
      return obj.hasOwnProperty(prop);
    }

    return false;
  }

  private static extractValue(obj: Object, prop: string): any {
    const parts = prop.split('.');
    let result = Object.assign({}, obj);

    // @ts-ignore
    parts.forEach(e => result = this.hasProperty(result, e) ? result[e] : null);

    return result;
  }
}

export class ExtractModel {

  source: string;
  target: string;

  constructor(source: string, target: string) {
    this.source = source;
    this.target = target;
  }
}
