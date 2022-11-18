import { WeatherClient } from './weather.client';

describe('WeatherClient', () => {
  it('should create an instance', () => {
    expect(new WeatherClient()).toBeTruthy();
  });
});
